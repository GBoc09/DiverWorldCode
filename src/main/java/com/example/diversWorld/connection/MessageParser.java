package com.example.diversWorld.connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageParser {
        private MessageParser(){}
    private static String dateTimeFormat = "yyyy-MM-dd_HH-mm-ss";

        public static Map<String, String> parseMessage(String message){
            if("".equals(message) || message == null){
                return null;
            }
            String[] params = message.split(";");
            HashMap<String, String> messageField = new HashMap<>();

            for (String param : params){
                String[] keyValue = param.split(":");
                messageField.put(keyValue[0], keyValue[1]);
            }
            return messageField;
        }
        public static List<ConnectionData> parseIPList (String ipList) {
            if (!ipList.equals("") && !ipList.equals("{null}")) {
                ArrayList<ConnectionData> connectionsList = new ArrayList();
                ipList = ipList.substring(1, ipList.length() - 1);
                String[] parsedList = ipList.split("_");
                String[] var6 = parsedList;
                int var5 = parsedList.length;

                for (int var4 = 0; var4 < var5; ++var4) {
                    String connection = var6[var4];
                    //connectionsList.add(new ConnectionData(connection.replace('-', ':')));
                }

                return connectionsList;
            } else {
                return new ArrayList();
            }
        }
}
