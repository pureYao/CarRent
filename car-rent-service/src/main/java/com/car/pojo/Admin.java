package com.car.pojo;

import lombok.Data;

@Data

public class Admin {
    private int id;
    private String name;
    private String phone_num;
    private String password;

    public Admin() {
    }

    public Admin(int id, String name, String phone_num, String password) {
        this.id = id;
        this.name = name;
        this.phone_num = phone_num;
        this.password = password;
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

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
