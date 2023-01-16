package com.example.DiversWorld.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SessionHandler {
    private String serverAddress = "localhost";
    private Integer serverPort = 4096;
    private Socket server = null;

    private Boolean connectToServer(){
        try {
            if(server != null){
                server.close();
            }
            server = new Socket(serverAddress, serverPort);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public boolean endSession(String userID, String ip, int port){
        String request = "request:remove; email:"+userID+";ip:"+ip+";port:"+port;
        return makeResponselessRequest(request);
    }
    public boolean startSession(String userID, String ip, int port){
        String request = "request:add;eamil:"+userID+"ip:"+ip+"port:"+port;
        return makeResponselessRequest(request);
    }
    public boolean makeResponselessRequest(String request){
        if(connectToServer()){
            try{
                var writer = new PrintWriter(server.getOutputStream(), true);
                writer.println(request);
                return true;
            } catch (IOException E){
                return false;
            }
        } else {
            return false;
        }
    }
    public List<ConnectionData> getConnectionData(String userID){
        String request = "request:get;email:"+userID;
        if (connectToServer()){
            try{
                var writer = new PrintWriter(server.getOutputStream(), true);
                var reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
                writer.println(request);
                String response = reader.readLine();
                String connections = MessageParser.parseMessage(response).get("data");
                return MessageParser.parseIPList(connections);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
