package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
       try(Connection connection = dataSource.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "INSERT INTO vehicles (VIN, make, model, year, color, vehicleType, odometer, price: VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
           preparedStatement.setString(1, "12347h7J2");
           preparedStatement.setString(2, "Ford");
           preparedStatement.setString(3, "Cadillac");
           preparedStatement.setInt(4, 2015);
           preparedStatement.setString(5, "blue");
           preparedStatement.setString(6, "car");
           preparedStatement.setInt(7, 3000);
           preparedStatement.setDouble(8,1500.00);

           preparedStatement.executeUpdate();
       }
       catch (SQLException ex) {
           ex.printStackTrace();

       }
    }

    public void removeVehicle(String VIN) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM vehicles WHERE VIN == 8K1FJ1K9A1W123456")) {
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
       List<Vehicle> vehicleList = new ArrayList<>();

       try(Connection connection = dataSource.getConnection();
           PreparedStatement prepState = connection.prepareCall(
                   "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?")) {
           prepState.executeUpdate();

       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return vehicleList;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> vehicleMakeList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement prepState = connection.prepareCall(
                    "SELECT * FROM vehicles WHERE model == ?")) {
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return vehicleMakeList;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicleYearList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement prepState = connection.prepareCall(
                    "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?")) {
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicleYearList;
    }


    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> colorCarList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement prepState = connection.prepareCall(
                    "SELECT * FROM vehicles WHERE color == ?")) {
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return colorCarList;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> mileageList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement prepState = connection.prepareCall(
                    "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?")) {
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mileageList;
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> typeList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement prepState = connection.prepareCall(
                    "SELECT * FROM vehicles WHERE type == ?")) {
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return typeList;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
