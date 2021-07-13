package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket sSocket = new ServerSocket(port)){
            ConsoleHelper.writeMessage("Сервер запущен");

            Socket socket;
            
            while(true) {
                socket = sSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            }
        }

    }

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение: " + socket.getRemoteSocketAddress());

            try(Connection connection = new Connection(socket)) {

                String userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);

                connectionMap.remove(userName);

                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            catch(Exception e) {
                ConsoleHelper.writeMessage("Ошибка обмена данными с сервером");
            }

            ConsoleHelper.writeMessage("Соединение с сервром успешно закрыто");

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message messageRequest = new Message(MessageType.NAME_REQUEST);
            Message messageAccept;
            String data;

            do {
                do {
                    do {
                        connection.send(messageRequest);
                    } while ((messageAccept = connection.receive()).getType() != MessageType.USER_NAME);

                    data = messageAccept.getData();

                } while (data.isEmpty());
            } while(connectionMap.containsKey(data));

            connectionMap.put(messageAccept.getData(), connection);

            connection.send(new Message(MessageType.NAME_ACCEPTED));

            return data;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for(String name : connectionMap.keySet()) {
                if(!name.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;

            while(true) {
                message = connection.receive();

                if(message.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Ошибка в типе сообщения");
                    continue;
                }

                sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
            }
        }
    }
}
