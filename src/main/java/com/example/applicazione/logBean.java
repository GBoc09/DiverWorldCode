package com.example.applicazione;

public class logBean {
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
    public String getUserId(){
        return userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}