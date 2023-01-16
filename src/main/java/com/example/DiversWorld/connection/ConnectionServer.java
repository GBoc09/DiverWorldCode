package com.example.DiversWorld.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionServer {
   private static final int MIN_PORT = 4096;
   private static final int MAX_PORT = 65000;
   private ServerSocket handler = null;
    private static ConnectionServer instance = null;
    private AtomicBoolean running = new AtomicBoolean(false);

    private ConnectionServer(){
        try{
            int port;
            do{
                port = new Random().nextInt(MAX_PORT - MIN_PORT) + MIN_PORT;
            } while (!available(port));
            handler = new ServerSocket(port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ConnectionServer getInstance(){
        if(instance == null){
            instance = new ConnectionServer();
        }
        return instance;
    }
    public void resetInstance(){
        instance = null;
    }
    public void startServer(){
        this.running.set(false);
    }
    public void stopServer(){
        this.running.set(false);
        try{
            this.handler.close();
        }catch (IOException e){}
    }
   /* @Override
    public void run(){
        while(true){
            try {
                if(running.get()){
                    return;
                }
                Socket connectedUser = handler.accept();

            }
        }
    }*/
    public ConnectionData getConnectionData(){
        String ip = "127.0.0.1";
        try{
            ip = InetAddress.getLocalHost().toString();
            ip = ip.substring(ip.indexOf("/")+1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return new ConnectionData(ip, handler.getLocalPort());
    }

    private boolean available(int port){
        try(Socket ignored = new Socket("localhost", port)){
            return false;
        }catch (IOException ignored){
            return true;
        }
    }
}
