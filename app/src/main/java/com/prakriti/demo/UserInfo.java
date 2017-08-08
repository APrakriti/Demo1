package com.prakriti.demo;

/**
 * Created by aprakriti on 5/4/2017.
 */

public class UserInfo {
    public  String id;
    public  String first_name;
    public  String middle_name;
    public  String last_name;
    public String address;
    public String contact;
    public   String email;
    public   String username;
    public String password;


    public UserInfo(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public UserInfo(String id, String first_name, String middle_name, String last_name, String address,
                    String contact, String email, String username, String password) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}




