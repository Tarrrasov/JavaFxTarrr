package com.example.javafxtarrr.controller;

import com.example.javafxtarrr.pojo.RemPasport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Controller {

    private ObservableList<RemPasport> remPasportsData = FXCollections.observableArrayList();

    @FXML
    private TableView<RemPasport> tableRemPasport;

    @FXML
    private TableColumn<RemPasport, Integer> idtPasportCol;

    @FXML
    private TableColumn<RemPasport, Date> tPasportRegDateCol;

    @FXML
    private TableColumn<RemPasport, String> tPasportClientCol;

    @FXML
    private TableColumn<RemPasport, Integer> tPasportWorkerCol;

    // инициализируем форму данными
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idtPasportCol.setCellValueFactory(new PropertyValueFactory<RemPasport, Integer>("id"));
        tPasportRegDateCol.setCellValueFactory(new PropertyValueFactory<RemPasport, Date>("regDate"));
        tPasportClientCol.setCellValueFactory(new PropertyValueFactory<RemPasport, String>("client"));
        tPasportWorkerCol.setCellValueFactory(new PropertyValueFactory<RemPasport, Integer>("idWorker"));
        System.out.println("отладочная строка 5"); // не смог понять, выполняется этот кусок хотя бы раз или нет

        // заполняем таблицу данными
        tableRemPasport.setItems(remPasportsData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {

        String stringDate ="01/12/1995";
        Date date1;
        try {
            date1 =new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            System.out.println("отладочная строка 6"); // тоже отладочный вывод - ни разу не вышел. Использовано потому что BrackPoint там не срабатывал
            remPasportsData.add(new RemPasport(1, date1,"qwerty", 1));
            remPasportsData.add(new RemPasport(2, date1,"dsfsdfw", 2));
            remPasportsData.add(new RemPasport(3, date1,"dsfdsfwe", 3));
            remPasportsData.add(new RemPasport(4, date1,"iueern", 4));
            remPasportsData.add(new RemPasport(5, date1,"woeirn", 5));

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
