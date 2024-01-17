package org.example.brewerymanagement.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow extends JFrame {

    public AddWindow() {
        setTitle("Add Ingredient");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //create labels and boxes (TODO: need to add more fields)
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(10);
        JButton addButton = new JButton("Add Ingredient");

        //add to panel (TODO: need to add more fields)
        setLayout(new GridLayout(4, 2));
        add(nameLabel);
        add(nameField);
        add(quantityLabel);
        add(quantityField);
        add(new JLabel());
        add(new JLabel());
        add(addButton);

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

        setVisible(true);
    }
}