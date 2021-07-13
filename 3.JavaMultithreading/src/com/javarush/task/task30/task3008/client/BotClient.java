package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public static void main(String[] args) {
        Client bot = new BotClient();
        bot.run();
    }

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName() {
        return "date_bot_" + (int)(Math.random()*100);
    }

    public class BotSocketThread extends SocketThread {
        public void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();

        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] values = message.split(":");

            if(values.length < 2)
                return;

            String name = values[0].trim();
            String data = values[1].trim();

            String format = null;

            switch(data) {
                case "дата" : format = "d.MM.YYYY"; break;
                case "день" : format = "d"; break;
                case "месяц" : format = "MMMM"; break;
                case "год" : format = "YYYY"; break;
                case "время" : format = "H:mm:ss"; break;
                case "час" : format = "H"; break;
                case "минуты" : format = "m"; break;
                case "секунды" : format = "s"; break;
            }

            if(format == null)
                return;

            sendTextMessage("Информация для " + name + ": " + new SimpleDateFormat(format).format(Calendar.getInstance().getTime()));
        }
    }
}
