package com.roomplannerBackend.roomplannerBackend.domain;

import java.util.List;

public class Customer {
    private String id;

    private int idType;

    private String names;

    private String surnames;

    private String phone;

    private String mail;

    private String password;

    private Boolean state;

    private Boolean admin;

    private List<Booking> bookings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Customer withoutPassword() {
        Customer customerWithoutPassword = new Customer();
        customerWithoutPassword.setId(this.getId());
        customerWithoutPassword.setIdType(this.getIdType());
        customerWithoutPassword.setNames(this.getNames());
        customerWithoutPassword.setSurnames(this.getSurnames());
        customerWithoutPassword.setPhone(this.getPhone());
        customerWithoutPassword.setMail(this.getMail());
        customerWithoutPassword.setState(this.getState());
        customerWithoutPassword.setAdmin(this.getAdmin());
        customerWithoutPassword.setBookings(this.getBookings());
        return customerWithoutPassword;
    }
}
