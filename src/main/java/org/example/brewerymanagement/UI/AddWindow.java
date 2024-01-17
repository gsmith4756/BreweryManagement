package org.example.brewerymanagement.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow extends JFrame {

    JPanel displayPanel;

    public AddWindow(String tableName) {
        setTitle("Add Ingredient");
        setSize(700, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //pick which fields to display

        switch(tableName){
            case "Hops":
                add(hopFields());
                break;
            case "Malt":
                break;
            case "Yeast":
                break;
            case "Canning Lines":
                break;
            case "Fermentation Vessels":
                break;
            case "Mash Tuns":
                break;
        }



        setVisible(true);
    }

    private JPanel hopFields(){


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
                double quantity = Double.parseDouble(quantityField.getText());

                //TODO: add logic to call DAO classes

                //close window
                dispose();
            }
        });

        //return panel
        return displayPanel;
    }
}