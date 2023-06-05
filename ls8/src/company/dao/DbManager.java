package company.dao;

import company.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    //Создаем подключение к бд
    private Connection connection;

    public void connect(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Инициируем подключение к бд
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", "root",
                    "root");
            System.out.println("CONNECTED");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        try{
            //готовим наш запрос в бд
            PreparedStatement statement = connection.prepareStatement( "SELECT * from mysql.Cars");

            //Запуск запроса
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                Double engine = resultSet.getDouble("engine_volume");

                cars.add(new Car(id, name,price,engine));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void addCar(Car car)  {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT into mysql.Cars (id, name, price, engine_volume)" + "value (null, ?, ?, ?)");

            statement.setString(1, car.getName());
            statement.setDouble(2, car.getPrice());
            statement.setDouble(3, car.getEngineVolume());

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
