package com.example.randomuserjusto.apiclient.entities;

public class User {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private DobRegistered dob;
    private DobRegistered registered;
    private String phone;
    private String cell;
    private Picture picture;
    private String nat;

    public User() { }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public DobRegistered getDob() {
        return dob;
    }

    public void setDob(DobRegistered dob) {
        this.dob = dob;
    }

    public DobRegistered getRegistered() {
        return registered;
    }

    public void setRegistered(DobRegistered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", login=" + login +
                ", dob=" + dob +
                ", registered=" + registered +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", picture=" + picture +
                ", nat='" + nat + '\'' +
                '}';
    }
}
