package org.example.brewerymanagement.dbconnection;
import org.example.brewerymanagement.equipment.MashTun;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MTDAO {

    private Connection connection;

    public MTDAO(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void create(MashTun mashTun) {
        String insertQuery = "INSERT INTO equipment (type, inUse, dateOfPurchase, capacity) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, mashTun.getType());
            preparedStatement.setBoolean(2, mashTun.isInUse());
            preparedStatement.setString(3, mashTun.getDateOfPurchase());
            preparedStatement.setInt(4, mashTun.getCapacity());

            preparedStatement.executeUpdate();
            System.out.println("MashTun created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public MashTun getMashTunById(int id) {
        MashTun mashTun = null;
        String selectQuery = "SELECT * FROM equipment WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mashTun = mapResultSetToMashTun(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mashTun;
    }

    public List<MashTun> getAllMashTuns() {
        List<MashTun> mashTunList = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM equipment WHERE type = 'MashTun'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MashTun mashTun = mapResultSetToMashTun(resultSet);
                mashTunList.add(mashTun);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mashTunList;
    }

    // Update
    public void update(MashTun mashTun) {
        String updateQuery = "UPDATE equipment SET type = ?, inUse = ?, dateOfPurchase = ?, capacity = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, mashTun.getType());
            preparedStatement.setBoolean(2, mashTun.isInUse());
            preparedStatement.setString(3, mashTun.getDateOfPurchase());
            preparedStatement.setInt(4, mashTun.getCapacity());
            preparedStatement.setInt(5, mashTun.getID());

            preparedStatement.executeUpdate();
            System.out.println("MashTun updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void delete(int id) {
        String deleteQuery = "DELETE FROM equipment WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.println("MashTun deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private MashTun mapResultSetToMashTun(ResultSet resultSet) throws SQLException {
        MashTun mashTun = new MashTun();
        mashTun.setId(resultSet.getInt("id"));
        mashTun.setType(resultSet.getString("type"));
        mashTun.setInUse(resultSet.getBoolean("inUse"));
        mashTun.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
        mashTun.setCapacity(resultSet.getInt("capacity"));

        return mashTun;
    }
}