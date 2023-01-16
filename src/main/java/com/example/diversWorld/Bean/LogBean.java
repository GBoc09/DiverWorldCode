package com.example.diversWorld.Bean;

public class LogBean implements Bean {
    /**
     * vanno controllati: il campo data  è stato rimpito nel formato MM/DD/YYYY
     * se nome e cognome sono solo caratteri
     * se all'interno della email è presente la @, il punto
     * se nella license number sono presenti solo numeri (VERIFICARE SUL BREVETTO SE è ALFANUMERICO)
     */
    protected String userID;
    protected String password;

    public void setUserID(String id){
        this.userID = id;
    }
    public String getUserID(){
        return userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}