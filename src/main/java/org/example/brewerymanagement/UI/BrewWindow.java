package org.example.brewerymanagement.UI;


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
                String selectedMalt = (String) maltNameBox.getSelectedItem();
                String selectedYeast = (String) yeastNameBox.getSelectedItem();

                //TODO: call DAO classes to remove specified ingredients

                //close window
                dispose();
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
}