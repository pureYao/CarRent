package com.car.pojo;

public class Car {
    private int id;
    private String name;
    private int color;
    private int isRent;
    private String desc;

    public Car() {
    }

    public Car(int id, String name, int color, int isRent, String desc) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.isRent = isRent;
        this.desc = desc;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIsRent() {
        return isRent;
    }

    public void setIsRent(int isRent) {
        this.isRent = isRent;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", isRent=" + isRent +
                ", desc='" + desc + '\'' +
                '}';
    }
}
