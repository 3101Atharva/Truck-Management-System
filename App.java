package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class App {
    public static void main(String[] args) {
       TruckService truckService = new TruckService();

       Truck tata = new Truck("TATA","2019",1000,"Rajesh");
       Truck Mahindra = new Truck("Mahindra","2018",1000,"Akash");
       Truck volvo = new Truck("volvo","2020",1000,"Avi");
       Truck Bajaj = new Truck("bajaj","2016",1000,"Abhishek");

       //adding data into database
       truckService.addTruck(tata);
       truckService.addTruck(Mahindra);
       truckService.addTruck(volvo);
       truckService.addTruck(Bajaj);

       //fetch
        Truck truck = truckService.getTruckById(1);
        System.out.println("Truck data"+truck);

       //updating truck data
        truck.setDriverName("Ravi");
        truckService.updateTruck(truck);
        System.out.println("Updated truck data:"+truckService.getTruckById(1));

        //get all truck data
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("All truck in DB");
        for(Truck truck1:allTrucks){
            System.out.println(truck1);
        }

        //delete truck data
        truckService.deleteTruck(2);
        System.out.println("Data deleted by id: "+2);

        allTrucks=truckService.getAllTrucks();
        System.out.println("All trucks after all operations");
        System.out.println(allTrucks);
    }
}

