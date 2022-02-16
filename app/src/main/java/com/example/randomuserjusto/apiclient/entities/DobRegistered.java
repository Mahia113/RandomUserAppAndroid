package com.example.randomuserjusto.apiclient.entities;

public class DobRegistered {

    private String date;
    private int age;

    public DobRegistered() { }

    public DobRegistered(String date, int age) {
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DobRegistered{" +
                "date='" + date + '\'' +
                ", age=" + age +
                '}';
    }
}
