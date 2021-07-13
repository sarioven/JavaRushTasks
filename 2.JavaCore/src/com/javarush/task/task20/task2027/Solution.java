package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'e', 'm', 'o', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        for(Word word : detectAllWords(crossword, "home", "same", "e"))
            System.out.println(word.toString());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int[] vecX = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] vecY = {0, -1, -1, -1, 0, 1, 1, 1};

        List<Word> wordList = new ArrayList<>();

        char[] wordChars;

        for(String word : words) {
            wordChars = word.toCharArray();

            Word wordCoords;

            for(int row=0; row < crossword.length; row++){
                for(int col=0; col < crossword[0].length; col++) {
                    if(crossword[row][col] != wordChars[0])
                        continue;

                    wordCoords = new Word(word);

                    wordCoords.setStartPoint(col, row);

                    int x, y;

                    outer:
                    for(int i=0; i < vecX.length; i++) {
                        for(int l=0; l < wordChars.length; l++) {
                            y = row + vecY[i]*l;
                            x = col + vecX[i]*l;

                            if(y < 0 || y > crossword.length-1 || x < 0 || x > crossword[0].length-1)
                                continue;

                            if(crossword[y][x] != wordChars[l])
                                break;

                            if(l == wordChars.length-1) {
                                wordCoords.setEndPoint(x, y);
                                wordList.add(wordCoords);
                                break outer;
                            }
                        }
                    }
                }
            }
        }

        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
