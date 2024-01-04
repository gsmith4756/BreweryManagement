package org.example.brewerymanagement.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.brewerymanagement.ingredients.Hop;

public class HopDAO {
    private final Connection connection;

    // Constructor to set the database connection
    public HopDAO(Connection connection) {
        this.connection = connection;
    }

    //CRUD Methods for DB manipulation

    // CREATE
    public void create(Hop hop) throws SQLException {
        String insertQuery = "INSERT INTO hops (name, quantity, price, harvestDate, IBU) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, hop.getName());
            statement.setDouble(2, hop.getQuantity());
            statement.setDouble(3, hop.getPrice());
            statement.setString(4, hop.getHarvestDate());
            statement.setInt(5, hop.getIBU());
            statement.executeUpdate();
        }
    }

    // READ
    public Hop read(int id) throws SQLException {
        String selectQuery = "SELECT * FROM hops WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractHopFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // UPDATE
    public void update(Hop hop) throws SQLException {
        String updateQuery = "UPDATE hops SET variety = ?, quantity = ?, price = ?, " +
                "harvestDate = ?, IBU = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, hop.getName());
            statement.setDouble(2, hop.getQuantity());
            statement.setDouble(3, hop.getPrice());
            statement.setString(4, hop.getHarvestDate());
            statement.setInt(5, hop.getIBU());
            statement.setInt(6, hop.getID());
            statement.executeUpdate();
        }
    }

    // DELETE
    public void delete(int id) throws SQLException {
        String deleteQuery = "DELETE FROM hops WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Helper method to extract a Hop object from query result
    private Hop extractHopFromResultSet(ResultSet resultSet) throws SQLException {

        Hop hop = new Hop();
        hop.setID(resultSet.getInt("id"));
        hop.setName(resultSet.getString("variety"));
        hop.setQuantity(resultSet.getDouble("quantity"));
        hop.setPrice(resultSet.getDouble("price"));
        hop.setHarvestDate(resultSet.getString("harvestDate"));
        hop.setIBU(resultSet.getInt("IBU"));
        return hop;
    }
}

