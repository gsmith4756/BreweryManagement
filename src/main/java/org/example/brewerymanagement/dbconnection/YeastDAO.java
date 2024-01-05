package org.example.brewerymanagement.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.brewerymanagement.ingredients.Yeast;

public class YeastDAO {

    private final Connection connection;
    public YeastDAO(Connection connection){
        this.connection=connection;

    }
}
