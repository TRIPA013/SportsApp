package com.aa.sportstree.sportstree.pojos;

/**
 * Created by Abhinav on 11/9/2014.
 */
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }



}
