package org.example.brewerymanagement.dbconnection;
import java.sql.*;
import java.util.ArrayList;

import org.example.brewerymanagement.ingredients.Malt;
import org.example.brewerymanagement.ingredients.Yeast;
import java.util.List;

public class YeastDAO {
    private Connection connection;

    public YeastDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Yeast> getAllYeasts() throws SQLException {
        List<Yeast> yeasts = new ArrayList<>();
        String query = "SELECT * FROM yeast";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {

                String strain = resultSet.getString("strain");
                double quantity = resultSet.getDouble("quantity");
                double price = resultSet.getDouble("price");
                String format = resultSet.getString("format");

                // Create Yeast object and add to list
                Yeast yeast = new Yeast(strain, quantity, price, format);
                yeasts.add(yeast);
            }
        }
        return yeasts;
    }

    //CRUD methods

    public void create(Yeast yeast) throws SQLException {
        String query = "INSERT INTO yeast (name, quantity, price, format) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeast.getName());
            preparedStatement.setDouble(2, yeast.getQuantity());
            preparedStatement.setDouble(3, yeast.getPrice());
            preparedStatement.setString(4, yeast.getFormat());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void remove(int id){

    }

    public void update(Yeast yeast) throws SQLException {
        String query = "UPDATE malt SET name = ?, quantity = ?, price = ?, format = ? WHERE name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeast.getName());
            preparedStatement.setDouble(2, yeast.getQuantity());
            preparedStatement.setDouble(3, yeast.getPrice());
            preparedStatement.setString(4, yeast.getFormat());
            preparedStatement.setString(5, yeast.getName());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(String strain) throws SQLException {
        String query = "DELETE FROM yeast WHERE strain = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, strain);

            preparedStatement.executeUpdate();
        }
    }

    //helper methods

    public Yeast readName(String name) {
        String query = "SELECT * FROM yeast WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractYeastFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {

        }
        return null;

    }

    private Yeast extractYeastFromResultSet(ResultSet resultSet) throws SQLException {

        Yeast yeast = new Yeast();
        yeast.setID(resultSet.getInt("id"));
        yeast.setName(resultSet.getString("name"));
        yeast.setQuantity(resultSet.getDouble("quantity"));
        yeast.setPrice(resultSet.getDouble("price"));
        yeast.setFormat(resultSet.getString("format"));

        return yeast;
    }


}