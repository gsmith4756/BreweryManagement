package org.example.brewerymanagement.dbconnection;
import org.example.brewerymanagement.ingredients.Malt;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaltDAO {
    private Connection connection;

    public MaltDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Malt> getAllMalts() throws SQLException {
        List<Malt> malts = new ArrayList<>();
        String query = "SELECT * FROM malt";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {

                String type = resultSet.getString("name");
                double quantity = resultSet.getDouble("quantity");
                double price = resultSet.getDouble("price");
                String format = resultSet.getString("format");

                // Create Malt objects and add list
                Malt malt = new Malt(type, quantity, price, format);
                malts.add(malt);
            }
        }
        return malts;
    }

    //CRUD methods

    public void create(Malt malt) throws SQLException {
        String query = "INSERT INTO malt (name, quantity, price, format) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, malt.getName());
            preparedStatement.setDouble(2, malt.getQuantity());
            preparedStatement.setDouble(3, malt.getPrice());
            preparedStatement.setString(4, malt.getFormat());

            preparedStatement.executeUpdate();
        }
    }

    public void update(Malt malt) throws SQLException {
        String query = "UPDATE malt SET name = ?, quantity = ?, price = ?, format = ? WHERE type = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, malt.getName());
            preparedStatement.setDouble(2, malt.getQuantity());
            preparedStatement.setDouble(3, malt.getPrice());
            preparedStatement.setString(4, malt.getFormat());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(String strain) throws SQLException {
        String query = "DELETE FROM malt WHERE name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, strain);

            preparedStatement.executeUpdate();
        }
    }
}