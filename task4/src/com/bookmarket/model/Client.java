package com.bookmarket.model;

public class Client {

    private String firstName;
    private String secondName;

    public Client(String firstName, String secondName) {
        setFirstName(firstName);
        setSecondName(secondName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
