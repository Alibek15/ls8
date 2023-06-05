package company;

import company.dao.DbManager;
import company.entity.Car;

import java.util.List;


public class Main {

    public static void main(String[] args)  {
       //JDBC - Java DataBase Connectivity
        //стандарт взаимодействия Java приложений с различными СуБД
        //java.sql - пакет
        //
        DbManager dbManager = new DbManager();

        dbManager.connect();



        Car car = new Car(null, "Lada", 10_000,6.3);

        dbManager.addCar(car);

        List<Car> cars = dbManager.getCars();

        cars.forEach(System.out::println);
                
    }
}