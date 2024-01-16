package org.example.brewerymanagement.dbconnection;
import org.example.brewerymanagement.equipment.CanningLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CLDAO {
    private Connection connection;

    public CLDAO(Connection connection) {
        this.connection = connection;
    }

    //CRUD
    public void create(CanningLine canningLine) throws SQLException {
        String insertSQL = "INSERT INTO canningLines (type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, canningLine.getType());
            statement.executeUpdate();
        }
    }


    public List<CanningLine> getAllCanningLines() throws SQLException {
        List<CanningLine> canningLines = new ArrayList<>();
        String selectSQL = "SELECT * FROM canningLines";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CanningLine cl = new CanningLine(
                        resultSet.getString("type")
                );
                canningLines.add(cl);
            }
        }
        return canningLines;
    }

    public void update(CanningLine canningLine) throws SQLException {
        String updateSQL = "UPDATE canningLines SET type=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(updateSQL)) {
            statement.setString(1, canningLine.getType());
            statement.setInt(5, canningLine.getID());
            statement.executeUpdate();
        }
    }

    // Delete a CanningLine from the database
    public void delete(int id) throws SQLException {
        String deleteSQL = "DELETE FROM canningLines WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(deleteSQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}