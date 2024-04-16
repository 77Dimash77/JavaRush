package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query,delimiter);
        ArrayList<String> a = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            a.add(token);
        }
        String[]res = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            res[i] = a.get(i);
        }
        return res;
    }
}
