package com.example.javafxtarrr;

//import com.example.javafxtarrr.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("IPSOBM.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Scene scene = new Scene(fxmlLoader.load());

        // подключение к БД
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            // с конфигурационным файлом
            try (Connection conn = getConnection()){
                 System.out.println("Connection to Store DB succesfull!");
            }
            // конец блока с конфигурационным файлом

/*
            // без конфигурационного файла
            String url = "jdbc:mysql://localhost/ipsobm";
            String username = "root";
            String password = "43924392";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                System.out.println("Connection to Store DB succesfull!");
            }
            // конец блока без конфигурационного файла
*/


        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }

        stage.setTitle("Hello!");
        System.out.println("1");
        stage.setScene(scene);
        System.out.println("2");
        stage.show();
    }

    public static Connection getConnection() throws SQLException, IOException{

        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        launch();
    }
}