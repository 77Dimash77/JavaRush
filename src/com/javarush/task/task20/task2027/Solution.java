package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'e', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'a', 'r', 'o', 'v'},
                {'m', 's', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> newList = detectAllWords(crossword, "home", "same");
        for (Word w : newList) {
            System.out.println(w.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        int[] indexM = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] indexN = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
        for (int j = 0; j < crossword.length; j++) {
            for (int i = 0; i < crossword[j].length; i++) {
                for(String s:words){
                    if (crossword[j][i] == (int) s.charAt(0)) {
                        for (int t = 0; t < indexM.length; t++) {
                            try {
                                StringBuilder temp = new StringBuilder();
                                int n = j;
                                int m = i;
                                for (int count = 0; count < s.length(); count++) {
                                    temp.append((char) crossword[n][m]);
                                    n = n + indexN[t];
                                    m = m + indexM[t];
                                }
                                if (temp.toString().equals(s)) {
                                    Word word = new Word(s);
                                    word.setStartPoint(i, j);
                                    word.setEndPoint(m - indexM[t], n - indexN[t]);
                                    list.add(word);
                                }
                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                        }
                    }
                }
            }
        }
        return list;
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