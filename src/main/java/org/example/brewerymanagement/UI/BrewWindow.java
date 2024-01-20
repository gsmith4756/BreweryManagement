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

public class BrewWindow extends JFrame {

    private Connection connection;

    public BrewWindow(Connection connection) {
        this.connection = connection;

        setTitle("Brew");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //create labels and boxes
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

        //create panels for each Ingredient
        JPanel hopsPanel = createPanel(hopsLabel, hopsNameBox, hopsQuantityField);
        JPanel maltPanel = createPanel(maltLabel, maltNameBox, maltQuantityField);
        JPanel yeastPanel = createPanel(yeastLabel, yeastNameBox, yeastQuantityField);

        //create initial layout
        setLayout(new GridLayout(4, 1));

        add(hopsPanel);
        add(maltPanel);
        add(yeastPanel);
        add(brewButton);


        //listener for button
        brewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get values from input boxes
                String selectedHops = (String) hopsNameBox.getSelectedItem();
                String selectedMalt = (String)maltNameBox.getSelectedItem();
                String selectedYeast = (String) yeastNameBox.getSelectedItem();

                int hopQuantity = Integer.parseInt(hopsQuantityField.getText());
                int maltQuantity = Integer.parseInt(maltQuantityField.getText());
                int yeastQuantity = Integer.parseInt(yeastQuantityField.getText());

                //SwingWorker to perform DB update tasks in background
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        //update all Ingredient tables in the background
                        try {
                            updateIngredientTable("hops", selectedHops, hopQuantity);
                            updateIngredientTable("malt", selectedMalt, maltQuantity);
                            updateIngredientTable("yeast", selectedYeast, yeastQuantity);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        //open main window again
                        SwingUtilities.invokeLater(() -> new UIClass(connection));
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

    private JPanel createPanel(JLabel label, JComboBox<String> nameBox, JTextField quantityField) {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(nameBox);
        panel.add(quantityField);
        return panel;
    }

    private void updateIngredientTable(String tableName, String ingredientName, int usedQuantity) throws SQLException {
        switch(tableName){
            case "hops":
                HopDAO hopDAO = new HopDAO(connection);
                Hop readHop = hopDAO.readName(ingredientName);
                readHop.removeQuantity(usedQuantity);
                hopDAO.update(readHop);
                break;
            case "malt":
                MaltDAO maltDAO = new MaltDAO(connection);
                Malt readMalt = maltDAO.readName(ingredientName);
                readMalt.removeQuantity(usedQuantity);
                maltDAO.update(readMalt);
                break;
            case "yeast":
                YeastDAO yeastDAO = new YeastDAO(connection);
                Yeast readYeast = yeastDAO.readName(ingredientName);
                readYeast.removeQuantity(usedQuantity);
                yeastDAO.update(readYeast);
                break;

        }
    }

    private void setFermentationVesselInUse() throws SQLException {
        //TODO
    }

    private void updateBeersTable(String hop, String malt, String yeast) throws SQLException{

    }
}