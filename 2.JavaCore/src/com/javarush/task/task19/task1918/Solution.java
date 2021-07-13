package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fReader = new FileReader(reader.readLine());

        reader.close();

        String data = "";

        while(fReader.ready())
            data += (char)fReader.read();

        fReader.close();

        getTags(data, args[0]);
    }

    public static String getTags(String data, String tag) {
        int lastLine;
        String line = null;

        while((lastLine = getLastClosedTag(data, tag, data.indexOf("</" + tag + ">"))) != -1) {
            line = data.substring(data.indexOf("<" + tag)+1, lastLine + tag.length() + 2);
            data = data.substring(lastLine + tag.length() + 3);

            System.out.println("<" + line + ">");

            if(getTags(line, tag) == null)
                continue;
        }

        return line;
    }

    public static int getLastClosedTag(String data, String tag, int startIndex) {
        int firstClosed = data.indexOf("</" + tag + ">", startIndex);
        int firstOpened = data.indexOf("<" + tag, startIndex);
        int lastClosed = data.indexOf("</" + tag + ">", firstClosed+1);

        if(firstClosed < firstOpened && firstOpened < lastClosed || lastClosed == -1)
            return firstClosed;
        else
            return getLastClosedTag(data, tag, lastClosed);
    }
}
