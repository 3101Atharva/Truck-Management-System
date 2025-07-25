package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {

    public void addTruck(Truck truck){
        String sql = "insert into trucks (name,model,capacity,driver_name) values (?,?,?,?)";

        try
        {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriverName());

            int update = preparedStatement.executeUpdate();
            System.out.println("Rows impacted:"+update);

        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    public Truck getTruckById(int id){
        String sql = "select * from trucks where id=?";
        Truck truck = new Truck();
        try{
            Connection connection = ConnectionDetails.getConnection();//To create add object that type we use ctr+alt+V shortcut
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return truck;
    }

    public void updateTruck(Truck truck){
        String sql = "update trucks set name=?,model=?,capacity=?,driver_name=? where id=?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4, truck.getDriverName());
            preparedStatement.setInt(5,truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row impacted: "+update);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<Truck> getAllTrucks()  {
        String sql = "select * from trucks";
        List<Truck> trucks = new ArrayList<Truck>();
        try{
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));
                trucks.add(truck);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    public void deleteTruck(int id){
        String deleteQuery ="delete from trucks where id=?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,id);
            int update =preparedStatement.executeUpdate();
            System.out.println("Row delete:"+update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


