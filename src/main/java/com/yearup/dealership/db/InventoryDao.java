package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // TODO: Implement the logic to add a vehicle to the inventory
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO dealership_id, VIN: VALUES (?, ?)")) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "127NCT226DJ");

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM vehicles WHERE VIN = 3W7DK72C32G123456")) {

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
