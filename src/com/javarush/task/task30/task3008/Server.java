package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
   private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

   public static void sendBroadcastMessage(Message message) throws IOException {
        for (Map.Entry<String,Connection> m : connectionMap.entrySet()){
            try {
                m.getValue().send(message);
            } catch (IOException e){
                ConsoleHelper.writeMessage("Error sending message");
            }

        }
    }



    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Input server port: ");
    try(  ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());) {
        ConsoleHelper.writeMessage("Server started...");
        while (true){
            new Handler(serverSocket.accept()).start();
        }
    } catch (Exception e){
        ConsoleHelper.writeMessage("Something wrong, Server socket closed.");
    }
    }



    private static class Handler extends Thread{
        Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }


       public void run(){
            if(socket!=null && socket.getRemoteSocketAddress() !=null){
                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());
            }
           String userName = null;
            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection,userName);

            } catch (IOException | ClassNotFoundException e){
ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    try {
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);
            }
       }

     
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(MessageType.TEXT == message.getType() && message!= null){
                   sendBroadcastMessage(new Message(MessageType.TEXT,userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }
       private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String,Connection> m : connectionMap.entrySet()){
                String a = m.getKey();
                if(!userName.equals(m.getKey())){
                    connection.send(new Message(MessageType.USER_ADDED,a));
                }

            }
        }

      private   String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME) {
                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }

            }
        }

    }
}
