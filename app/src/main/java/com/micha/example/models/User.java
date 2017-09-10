package com.micha.example.models;

/**
 * Created by delaroy on 4/13/17.
 */
public class User {
    public String uid;
    public String email;
    public String firebaseToken;
    public String test;
    public String age;
    public String height;
    public String weight;
    public String gender;
    public boolean c;
    public boolean a;
    public boolean e;

    public User(){

    }

    public User(String uid, String email, String firebaseToken, String test, String age, String height, String weight, String gender, boolean c, boolean a, boolean e) {
        this.uid = uid;
        this.email = email;
        this.firebaseToken = firebaseToken;
        this.test = test;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.c = c;
        this.a = a;
        this.e = e;
    }

    public User(String uid, String email, String firebaseToken){
        this.uid = uid;
        this.email = email;
        this.firebaseToken = firebaseToken;
    }
}
