package org.example.brewerymanagement.UI;


import org.example.brewerymanagement.dbconnection.*;
import org.example.brewerymanagement.equipment.*;
import org.example.brewerymanagement.ingredients.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;

public class BrewWindow extends JFrame {

    private Connection connection;

    public BrewWindow(Connection connection) {
        this.connection = connection;

        setTitle("Brew");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //create labels and boxes
        JLabel beerNameLabel = new JLabel("Beer Name:");
        JTextField beerNameBox = new JTextField(10);
        JLabel hopsLabel = new JLabel("Hops Used:");
        JComboBox<String> hopsNameBox = createComboBox("hops");
        JTextField hopsQuantityField = new JTextField(10);
        JLabel maltLabel = new JLabel("Malt Used:");
        JComboBox<String> maltNameBox = createComboBox("malt");
        JTextField maltQuantityField = new JTextField(10);
        JLabel yeastLabel = new JLabel("Yeast Used:");
        JComboBox<String> yeastNameBox = createComboBox("yeast");
        JTextField yeastQuantityField = new JTextField(10);
        JButton brewButton = new JButton("Brew");
        brewButton.setPreferredSize(new Dimension(150, 40));


        //create panels + use GridBagConstraints for even layout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(beerNameLabel, gbc);
        gbc.gridy++;
        inputPanel.add(beerNameBox, gbc);
        gbc.gridy++;
        inputPanel.add(hopsLabel, gbc);
        gbc.gridy++;
        inputPanel.add(hopsNameBox, gbc);
        gbc.gridy++;
        inputPanel.add(hopsQuantityField, gbc);
        gbc.gridy++;
        inputPanel.add(maltLabel, gbc);
        gbc.gridy++;
        inputPanel.add(maltNameBox, gbc);
        gbc.gridy++;
        inputPanel.add(maltQuantityField, gbc);
        gbc.gridy++;
        inputPanel.add(yeastLabel, gbc);
        gbc.gridy++;
        inputPanel.add(yeastNameBox, gbc);
        gbc.gridy++;
        inputPanel.add(yeastQuantityField, gbc);
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(brewButton, gbc);

        // Create initial layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);


        //listener for button
        brewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get values from input boxes
                String beerName = beerNameBox.getText();
                String selectedHops = (String) hopsNameBox.getSelectedItem();
                String selectedMalt = (String)maltNameBox.getSelectedItem();
                String selectedYeast = (String) yeastNameBox.getSelectedItem();

                int hopQuantity = Integer.parseInt(hopsQuantityField.getText());
                int maltQuantity = Integer.parseInt(maltQuantityField.getText());
                int yeastQuantity = Integer.parseInt(yeastQuantityField.getText());

                //run inputs through validation method
                if (!isValidQuantityInput(hopsQuantityField.getText()) ||
                        !isValidQuantityInput(maltQuantityField.getText()) ||
                        !isValidQuantityInput(yeastQuantityField.getText())) {
                    JOptionPane.showMessageDialog(BrewWindow.this, "Invalid quantity input, please only enter positive numbers.");
                    return;
                }

                //use SwingWorker to perform DB tasks in background
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        try {
                            updateIngredientTable("hops", selectedHops, hopQuantity);
                            updateIngredientTable("malt", selectedMalt, maltQuantity);
                            updateIngredientTable("yeast", selectedYeast, yeastQuantity);
                            updateBeersTable(beerName, selectedHops, selectedMalt, selectedYeast);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void done() {

                        SwingUtilities.invokeLater(() -> {
                            // open main window again
                            new UIClass(connection);
                        });
                    }
                };

                worker.execute();
            }
        });

        setVisible(true);
    }

    private JComboBox<String> createComboBox(String tableName) {
        JComboBox<String> comboBox = new JComboBox<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM " + tableName);
            while (results.next()) {
                comboBox.addItem(results.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comboBox;
    }


    private void updateIngredientTable(String tableName, String ingredientName, double usedQuantity) throws SQLException {
        switch(tableName){
            case "hops":
                try {
                    HopDAO hopDAO = new HopDAO(connection);
                    Hop readHop = hopDAO.readName(ingredientName);
                    readHop.removeQuantity(usedQuantity);
                    hopDAO.update(readHop);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "malt":
                try {
                    MaltDAO maltDAO = new MaltDAO(connection);
                    Malt readMalt = maltDAO.readName(ingredientName);
                    readMalt.removeQuantity(usedQuantity);
                    maltDAO.update(readMalt);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case "yeast":
                try {
                    YeastDAO yeastDAO = new YeastDAO(connection);
                    Yeast readYeast = yeastDAO.readName(ingredientName);
                    readYeast.removeQuantity(usedQuantity);
                    yeastDAO.update(readYeast);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;

        }
    }


    private void updateBeersTable(String name, String hop, String malt, String yeast) throws SQLException {

        Date brewDate = new Date(System.currentTimeMillis());

        FVDAO fvdao = new FVDAO(connection);
        FermentationVessel availableFV = fvdao.getAvailableFermentationVessel();

        //check if there is an availableFV
        if (availableFV != null) {
            availableFV.setInUse(true);
            fvdao.update(availableFV);
            System.out.println(availableFV.getName());

            try {
                String insertQuery = "INSERT INTO beersbrewing (beerName, brewDate, hopsUsed, maltUsed, yeastUsed, fvUsed) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setDate(2, brewDate);
                    preparedStatement.setString(3, hop);
                    preparedStatement.setString(4, malt);
                    preparedStatement.setString(5, yeast);
                    preparedStatement.setString(6, availableFV.getName());

                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {

            System.out.println("No available fermentation vessel found.");
        }
    }
    //simple input validation for positive numbers only
    private boolean isValidQuantityInput(String input) {
        try {
            int quantity = Integer.parseInt(input);
            return quantity >= 0; // Accept only non-negative integers
        } catch (NumberFormatException e) {
            return false; // Not a valid integer
        }
    }
}