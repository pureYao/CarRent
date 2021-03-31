package com.car.pojo;

import java.util.Date;

public class Rent {
    private int id;
    private int tenantId;
    private int carId;
    private Date rentTime;
    private int restTime;
    private int rentStatus;

    public Rent() {
    }

    public Rent(int id, int tenantId, int carId, Date rentTime, int restTime, int rentStatus) {
        this.id = id;
        this.tenantId = tenantId;
        this.carId = carId;
        this.rentTime = rentTime;
        this.restTime = restTime;
        this.rentStatus = rentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getRentTime() {
        return rentTime;
    }

    public void setRentTime(Date rentTime) {
        this.rentTime = rentTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public int getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(int rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", carId=" + carId +
                ", rentTime=" + rentTime +
                ", restTime=" + restTime +
                ", rentStatus=" + rentStatus +
                '}';
    }
}
