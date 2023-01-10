package com.example.DiversWorld.Bean;

public class UserBean { //implements Bean
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String picProfPath;

    public String getUserID(){
        return this.username;
    }

    public String getName(){
        return this.name;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPicProfPath(){
        return this.picProfPath;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicProfPath(String picProfPath) {
        this.picProfPath = picProfPath;
    }
}
