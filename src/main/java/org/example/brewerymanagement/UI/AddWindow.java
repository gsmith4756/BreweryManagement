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

        JLabel quantityLabel = new JLabel("Quantity (KG):");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price (£):");
        JTextField priceField = new JTextField(10);

        JLabel harvestDateLabel = new JLabel("Harvest Date (dd/mm/yyyy):");
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
                //validate inputs
                if (!isValidIntInput(quantityField.getText()) || !isValidDoubleInput(priceField.getText()) || !isValidIntInput(IBUField.getText()) || !isValidDateFormat(harvestDateField.getText())) {
                    JOptionPane.showMessageDialog(AddWindow.this, "Invalid input, please check your entries", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

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

        JLabel quantityLabel = new JLabel("Quantity (KG):");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price (£):");
        JTextField priceField = new JTextField(10);

        JLabel formatLabel = new JLabel("Format(Crushed/Whole):");
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

                //validate inputs
                if (!isValidDoubleInput(quantityField.getText()) || !isValidDoubleInput(priceField.getText())) {
                    JOptionPane.showMessageDialog(AddWindow.this, "Invalid input, please check your entries", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

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

        JLabel quantityLabel = new JLabel("Quantity (KG):");
        JTextField quantityField = new JTextField(10);

        JLabel priceLabel = new JLabel("Price (£):");
        JTextField priceField = new JTextField(10);

        JLabel formatLabel = new JLabel("Format (Liquid/Dried):");
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

                //validate inputs
                if (!isValidDoubleInput(quantityField.getText()) || !isValidDoubleInput(priceField.getText())) {
                    JOptionPane.showMessageDialog(AddWindow.this, "Invalid input, please check your entries", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText();
                double quantity = Double.parseDouble(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                String format = formatField.getText();

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
        JLabel nameLabel = new JLabel("Type:");
        JTextField nameField = new JTextField(20);

        JLabel containerTypeLabel = new JLabel("Container type (Can/Bottle):");
        JTextField containerTypeField = new JTextField(20);

        JLabel DOPLabel = new JLabel("Date of Purchase (dd/mm/yyyy):");
        JTextField DOPField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(containerTypeLabel);
        displayPanel.add(containerTypeField);
        displayPanel.add(DOPLabel);
        displayPanel.add(DOPField);
        displayPanel.add(addButton);

        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isValidDateFormat(DOPField.getText())) {
                    JOptionPane.showMessageDialog(AddWindow.this, "Invalid date, please use dd/mm/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText();
                String containerType = containerTypeField.getText();
                boolean inUse = false; //default, maybe redundant
                String dateOfPurchase = DOPField.getText();

                CanningLine newCanningLine = new CanningLine(name,dateOfPurchase, containerType);
                CLDAO canningLineDAO = new CLDAO(connection);

                try {
                    canningLineDAO.create(newCanningLine);
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

    private JPanel fermentationVesselsFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel DOPLabel = new JLabel("Date of Purchase (dd/mm/yyyy):");
        JTextField DOPField = new JTextField(10);

        JLabel capacityLabel = new JLabel("Capacity (L):");
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

                //validate inputs
                if (!isValidIntInput(capacityField.getText()) || !isValidDateFormat(DOPField.getText())) {
                    JOptionPane.showMessageDialog(AddWindow.this, "Invalid input, please check your entries", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText();
                int capacity = Integer.parseInt(capacityField.getText());
                String dateOfPurchase = DOPField.getText();

                FermentationVessel newFermentationVessel = new FermentationVessel(name,dateOfPurchase,capacity);
                FVDAO fermentationVesselDAO = new FVDAO(connection);

                try {
                    fermentationVesselDAO.create(newFermentationVessel);
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

    private JPanel mashTunsFields(Connection connection){


        displayPanel = new JPanel(new GridLayout());

        setLayout(new GridLayout(2, 2));
        //create labels and boxes
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel capacityLabel = new JLabel("Capacity (L):");
        JTextField capacityField = new JTextField(20);

        JLabel DOPLabel = new JLabel("Date of Purchase (DD/MM/YYYY):");
        JTextField DOPField = new JTextField(10);

        JButton addButton = new JButton("Add");

        //add to panel

        displayPanel.add(nameLabel);
        displayPanel.add(nameField);
        displayPanel.add(capacityLabel);
        displayPanel.add(capacityField);
        displayPanel.add(DOPLabel);
        displayPanel.add(DOPField);
        displayPanel.add(addButton);


        //listener for add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isValidIntInput(capacityField.getText()) || !isValidDateFormat(DOPField.getText())) {
                    JOptionPane.showMessageDialog(AddWindow.this, "Invalid input, please check your entries", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText();
                int capacity = Integer.parseInt(capacityField.getText());
                String dateOfPurchase = DOPField.getText();

                MashTun newMashTun = new MashTun(name,dateOfPurchase,capacity);
                MTDAO mtDAO = new MTDAO(connection);

                mtDAO.create(newMashTun);
                SwingUtilities.invokeLater(() -> new UIClass(connection));

                //close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }

    //input validation methods
    private boolean isValidIntInput(String input) {
        try {
            int value = Integer.parseInt(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDoubleInput(String input) {
        try {
            double value = Double.parseDouble(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isValidDateFormat(String date) {
        try {
            String[] sections = date.split("/");
            if (sections.length == 3) {
                int day = Integer.parseInt(sections[0]);
                int month = Integer.parseInt(sections[1]);
                int year = Integer.parseInt(sections[2]);
                return day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1000;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}