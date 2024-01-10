package org.example.brewerymanagement.UI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class UIClass extends JFrame {

    private JTable table;

    public UIClass(Connection connection) {
        setTitle("Brewery Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(0,1));

        //create a JPanel to hold the JTable
        JPanel panel = new JPanel();


        //array to hold table names
        String[] tables = {"hops", "malt", "yeast"};


        //fetch data from MySQL to populate the JTable



        try{
            for (String table: tables) {

                Statement statement = connection.createStatement();



                //get results for specified table
                ResultSet results = statement.executeQuery("SELECT * FROM " + table);
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

                    JTable tableComponent = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(tableComponent);
                    JPanel tablePanel = new JPanel();
                    tablePanel.add(scrollPane);
                    panel.add(tablePanel);
                }

                //create individual components and add to JTable
                JTable tableComponent = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(tableComponent);
                JPanel tablePanel = new JPanel();
                tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
                tablePanel.add(scrollPane);
                add(new JScrollPane(tablePanel));
            }


            } catch(SQLException e){
                e.printStackTrace();
            }




        getContentPane().add(panel);
        setVisible(true);
        }

    }

