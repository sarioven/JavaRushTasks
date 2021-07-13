package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread sThread = getSocketThread();
        sThread.setDaemon(true);
        sThread.start();

        try {
            synchronized(this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Возникло исключение в ожидании потока подключения");
            return;
        }

        if(clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.Для выхода наберите команду 'exit'.");
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }

        String message;

        while(clientConnected) {
            if((message = ConsoleHelper.readString()).equals("exit"))
                break;

            if(shouldSendTextFromConsole()) {
                sendTextMessage(message);
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите IP сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите PORT сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите Ваше имя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch(IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Произошла ошибка отправки сообщения");
        }
    }

    public class SocketThread extends Thread {
        public void run() {
            String ip = getServerAddress();
            int port = getServerPort();

            try (
                    Socket socket = new Socket(ip, port);
            ) {
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (Exception e) {
                notifyConnectionStatusChanged(false);
            }

        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " - Вошёл в чат");
        }
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " - Покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized(Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message;
            MessageType type;

            while(true) {
                message = connection.receive();

                type = message.getType();

                if(type == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if(type == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;
            MessageType type;

            while(true) {
                message = connection.receive();

                type = message.getType();

                if(type == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                }
                else if(type == MessageType.USER_ADDED) {
                        informAboutAddingNewUser(message.getData());
                }
                else if(type == MessageType.USER_REMOVED) {
                        informAboutDeletingNewUser(message.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }
}
