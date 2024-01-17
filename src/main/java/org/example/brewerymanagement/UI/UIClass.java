package org.example.brewerymanagement.UI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class UIClass extends JFrame {

    private Connection connection;
    private JPanel mainPanel;

    public UIClass(Connection connection) {
        this.connection=connection;

        mainPanel = new JPanel(new BorderLayout());

        setTitle("Brewery Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setLayout(new GridLayout(0,1));


        //array to hold table names
        String[] ingredientsTables = {"hops", "malt", "yeast"};
        String[] equipmentTables = {"canningLines", "mashTuns", "fermentationVessels"};
        String[] ingredientTitles = {"Ingredients","Hops","Malt","Yeast"};
        String[] equipmentTitles = {"Equipment","Canning Lines","Mash Tuns", "Fermentation Vessels"};
        //create panels for Ingredients and Equipment subclasses
        JPanel ingredientPanel = fetchData(ingredientTitles,ingredientsTables);
        JPanel equipmentPanel = fetchData(equipmentTitles,equipmentTables);

        //add the panels to the main panel
        mainPanel.add(ingredientPanel,BorderLayout.WEST);
        mainPanel.add(equipmentPanel,BorderLayout.EAST);

        //create brew button
        JButton brewButton = new JButton("Brew");

        //create listener for brew button
        brewButton.addActionListener(e -> brewButtonListener());

        //panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(brewButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);



        }



    private JPanel fetchData(String[] titles, String[] tables) {
        JPanel tablePanel = new JPanel(new BorderLayout());

        //create the panel for tables
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        //fetch + display data
        for (int i = 0; i < tables.length; i++) {
            //make index variable final so lambda function can use it
            final int currentIndex = i;

            try {
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery("SELECT * FROM " + tables[currentIndex]);
                ResultSetMetaData metaData = results.getMetaData();

                int columnCount = metaData.getColumnCount();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<Object>> data = new Vector<>();

                for (int x = 1; x <= columnCount; x++) {
                    columnNames.add(metaData.getColumnName(x));
                }

                while (results.next()) {
                    Vector<Object> row = new Vector<>();
                    for (int x = 1; x <= columnCount; x++) {
                        row.add(results.getObject(x));
                    }
                    data.add(row);
                }

                JTable tableComponent = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(tableComponent);

                //add table title
                JLabel tableLabel = new JLabel(titles[currentIndex + 1]);
                tableLabel.setHorizontalAlignment(SwingConstants.LEFT);
                tableLabel.setFont(new Font("Arial", Font.BOLD, 16));
                innerPanel.add(tableLabel);
                innerPanel.add(scrollPane);

                //add individual add buttons + respective listeners
                JButton addButton = new JButton("Add");
                addButton.addActionListener(e -> addButtonListener(titles[currentIndex + 1]));
                innerPanel.add(addButton);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //add title labels
        JLabel titleLabel = new JLabel(titles[0]);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tablePanel.add(titleLabel, BorderLayout.NORTH);
        tablePanel.add(innerPanel, BorderLayout.CENTER);

        return tablePanel;
    }

    private void brewButtonListener() {
        new BrewWindow(connection);
    }

    private void addButtonListener(String tableName) {
        System.out.println(tableName);
        new AddWindow(tableName);
    }






}

