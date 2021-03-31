package com.car.pojo;

public class Tenant {
    private int id;
    private String name;
    private int sex;
    private String phoneNum;
    private String pwd;
    private String idNum;
    private String addr;
    private int isTrue;

    public Tenant() {
    }

    public Tenant(int id, String name, int sex, String phoneNum, String pwd, String idNum, String addr, int isTrue) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.pwd = pwd;
        this.idNum = idNum;
        this.addr = addr;
        this.isTrue = isTrue;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(int isTrue) {
        this.isTrue = isTrue;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                ", pwd='" + pwd + '\'' +
                ", idNum='" + idNum + '\'' +
                ", addr='" + addr + '\'' +
                ", isTrue=" + isTrue +
                '}';
    }
}
