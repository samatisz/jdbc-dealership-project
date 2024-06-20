package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        // TODO: Implement the logic to add a sales contract
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO sales_contract (contract_id, VIN, sale_date, price: VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, "12347h7J2");
           // preparedStatement.setDate(3, 2024-06-23); - red issues
            preparedStatement.setDouble(4, 10000.00);

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
