package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        // TODO: Implement the logic to add a lease contract
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO lease_contract (contract_id, VIN, lease_start, lease_end, monthly_payment: VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "12347h7J2");
            // preparedStatement.setDate(3, 2024-06-23); - red issues
            //preparedStatement.setDate(4, 2026-01-01);
            preparedStatement.setDouble(4, 250.00);

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    }
}
