package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Truck {
    private int id;

    private String name;

    private String model;

    private int capacity;

    private String driverName;

    Truck() {

    }


    public Truck( String name, String model, int capacity, String driverName) {
        this.name = name;
        this.model = model;
        this.capacity = capacity;
        this.driverName = driverName;
    }


    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", driverName='" + driverName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


}

