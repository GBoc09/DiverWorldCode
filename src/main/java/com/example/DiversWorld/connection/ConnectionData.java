package com.example.DiversWorld.connection;

public class ConnectionData {
    private String ip;
    private int port;
    public ConnectionData(String data, int port){
        String[] parsedData = data.split(":");
        ip = parsedData[0];
        port = Integer.valueOf(parsedData[1]);
    }
    public String getIp(){
        return this.ip;
    }
    public int getPort(){
        return this.port;
    }
    public String toString(){
        return ip +":" + port;
    }
}
