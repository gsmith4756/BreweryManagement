package org.example.brewerymanagement.dbconnection;
import java.sql.*;
import java.util.ArrayList;
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
        String query = "INSERT INTO yeast (strain, quantity, price, format) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, yeast.getStrain());
            preparedStatement.setDouble(2, yeast.getQuantity());
            preparedStatement.setDouble(3, yeast.getPrice());
            preparedStatement.setString(4, yeast.getFormat());

            preparedStatement.executeUpdate();
        }
    }

    public void remove(int id){

    }

    public void update(String strain, double newQuantity) throws SQLException {
        String query = "UPDATE yeast SET quantity = ? WHERE strain = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, newQuantity);
            preparedStatement.setString(2, strain);

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


}