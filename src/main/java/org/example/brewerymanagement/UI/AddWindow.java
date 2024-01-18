package org.example.brewerymanagement.UI;

import org.example.brewerymanagement.dbconnection.*;
import org.example.brewerymanagement.ingredients.*;
import org.example.brewerymanagement.equipment.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddWindow extends JFrame {

    JPanel displayPanel;

    public AddWindow(Connection connection, String tableName) {
        setTitle("Add Ingredient");
        setSize(700, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //pick which fields to display

        switch(tableName){
            case "Hops":
                add(hopFields(connection));
                break;
            case "Malt":
                add(maltFields(connection));
                break;
            case "Yeast":
                add(yeastFields(connection));
                break;
            case "Canning Lines":
                add(canningLinesFields(connection));
                break;
            case "Fermentation Vessels":
                add(fermentationVesselsFields(connection));
                break;
            case "Mash Tuns":
                add(mashTunsFields(connection));
                break;
        }



        setVisible(true);
    }

    private JPanel hopFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(10);

        JLabel harvestDateLabel = new JLabel("Harvest Date:");
        JTextField harvestDateField = new JTextField(10);

        JLabel IBULabel = new JLabel("IBU:");
        JTextField IBUField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(quantityLabel);
        displayPanel.add(quantityField);
        displayPanel.add(priceLabel);
        displayPanel.add(priceField);
        displayPanel.add(harvestDateLabel);
        displayPanel.add(harvestDateField);
        displayPanel.add(IBULabel);
        displayPanel.add(IBUField);
        displayPanel.add(addButton);

        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                String harvestDate = harvestDateField.getText();
                int IBU = Integer.parseInt(IBUField.getText());

                Hop newHop = new Hop(name,quantity,price,harvestDate,IBU);
                HopDAO hopDAO = new HopDAO(connection);


                try {
                    hopDAO.create(newHop);
                    SwingUtilities.invokeLater(() -> new UIClass(connection));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                //close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }

    private JPanel maltFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(10);

        JLabel formatLabel = new JLabel("Format:");
        JTextField formatField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(quantityLabel);
        displayPanel.add(quantityField);
        displayPanel.add(priceLabel);
        displayPanel.add(priceField);
        displayPanel.add(formatLabel);
        displayPanel.add(formatField);
        displayPanel.add(addButton);

        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double quantity = Double.parseDouble(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                String format = formatField.getText();

                Malt newMalt = new Malt(name, quantity, price, format);
                MaltDAO maltDAO = new MaltDAO(connection);

                try {
                    maltDAO.create(newMalt);
                    SwingUtilities.invokeLater(() -> new UIClass(connection));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                //close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }

    private JPanel yeastFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(10);

        JLabel formatLabel = new JLabel("Format:");
        JTextField formatField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(quantityLabel);
        displayPanel.add(quantityField);
        displayPanel.add(priceLabel);
        displayPanel.add(priceField);
        displayPanel.add(formatLabel);
        displayPanel.add(formatField);
        displayPanel.add(addButton);

        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double quantity = Double.parseDouble(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                String format = formatField.getText();  // New field for Yeast

                Yeast newYeast = new Yeast(name, quantity, price, format);
                YeastDAO yeastDAO = new YeastDAO(connection);

                try {
                    yeastDAO.create(newYeast);
                    SwingUtilities.invokeLater(() -> new UIClass(connection));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }

    private JPanel canningLinesFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField(20);

        JLabel containerTypeLabel = new JLabel("Container type:");
        JTextField containerTypeField = new JTextField(20);

        JLabel DOPLabel = new JLabel("Date of Purchase:");
        JTextField DOPField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(typeLabel);
        displayPanel.add(typeField);
        displayPanel.add(containerTypeLabel);
        displayPanel.add(containerTypeField);
        displayPanel.add(DOPLabel);
        displayPanel.add(DOPField);
        displayPanel.add(addButton);

        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = typeField.getText();
                String containerType = containerTypeField.getText();
                boolean inUse = false; // Default value
                String dateOfPurchase = DOPField.getText();

                CanningLine newCanningLine = new CanningLine(dateOfPurchase, containerType);
                CLDAO canningLineDAO = new CLDAO(connection);

                try {
                    canningLineDAO.create(newCanningLine);
                    SwingUtilities.invokeLater(() -> new UIClass(connection));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }

    private JPanel fermentationVesselsFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel DOPLabel = new JLabel("Date of Purchase:");
        JTextField DOPField = new JTextField(10);

        JLabel capacityLabel = new JLabel("Capacity:");
        JTextField capacityField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(DOPLabel);
        displayPanel.add(DOPField);
        displayPanel.add(capacityLabel);
        displayPanel.add(capacityField);
        displayPanel.add(addButton);

        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String DOP = DOPField.getText();
                int capacity = Integer.parseInt(capacityField.getText());

                //TODO: add logic to call DAO classes

                //close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }

    private JPanel mashTunsFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel DOPLabel = new JLabel("Date of Purchase:");
        JTextField DOPField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(DOPLabel);
        displayPanel.add(DOPField);
        displayPanel.add(addButton);


        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String DOP = DOPField.getText();

                //TODO: add logic to call DAO classes

                //close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }
}