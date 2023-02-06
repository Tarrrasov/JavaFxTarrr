package com.example.javafxtarrr.pojo;

import java.util.Date;

public class RemPasport {
    private Integer id;
    private Date regDate;
    private String client;
    private Integer idWorker;

    public RemPasport(Integer id, Date regDate, String client, Integer idWorker) {
        this.id = id;
        this.regDate = regDate;
        this.client = client;
        this.idWorker = idWorker;
        System.out.println("отладочная строка 4"); // не смог понять, выполняется этот кусок хотя бы раз или нет
    }

    public RemPasport() {  }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getregDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client= client;
    }

    public int getIdWorker() {
        return idWorker;
    }
    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

}
