package com.example.demo.data;


public class UserDetails {
    public String email;
    public String firstName;
    public String lastName;

    public UserDetails(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("UserDetails[email='%s', firstName='%s', lastName='%s']", email, firstName, lastName);
    }
}
