package org.example.brewerymanagement.dbconnection;
import org.example.brewerymanagement.equipment.FermentationVessel;
import org.example.brewerymanagement.equipment.Equipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FVDAO {
    private Connection connection;

    public FVDAO(Connection connection) {
        this.connection = connection;
    }

    //CRUD methods
    public void create(FermentationVessel fv) throws SQLException {
        String insertSQL = "INSERT INTO fermentationvessels (name, date_of_purchase, capacity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, fv.getName());
            statement.setString(2, fv.getDateOfPurchase());
            statement.setInt(3, fv.getCapacity());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public List<FermentationVessel> getAllFermentationVessels() throws SQLException {
        List<FermentationVessel> fermentationVessels = new ArrayList<>();
        String selectSQL = "SELECT * FROM fermentationvessels";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FermentationVessel fv = new FermentationVessel(
                        resultSet.getString("name"),
                        resultSet.getString("dateOfPurchase"),
                        resultSet.getInt("capacity")
                );
                fermentationVessels.add(fv);
            }
        }
        return fermentationVessels;
    }


    public void update(FermentationVessel fv) throws SQLException {
        String updateSQL = "UPDATE fermentationvessels SET name=?, date_of_purchase=?, capacity=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(updateSQL)) {
            statement.setString(1, fv.getName());
            statement.setString(2, fv.getDateOfPurchase());
            statement.setInt(3, fv.getCapacity());
            statement.setInt(4, fv.getID());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String deleteSQL = "DELETE FROM fermentationvessels WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(deleteSQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
