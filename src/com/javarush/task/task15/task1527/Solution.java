package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        scanner.close();

        if (!url.isEmpty()) {
            String paramNames = "";
            String objValue = null;

            String paramsString = url.substring(url.indexOf("?") + 1);
            while (paramsString.length() > 0) {
                int ampersandPosition = paramsString.indexOf("&");
                String paramString = (ampersandPosition == -1) ? paramsString : paramsString.substring(0, ampersandPosition);
                paramsString = (ampersandPosition == -1) ? "" : paramsString.substring(ampersandPosition + 1);

                int equalsPosition = paramString.indexOf("=");
                String key = (equalsPosition == -1) ? paramString : paramString.substring(0, equalsPosition);
                paramNames += key + " ";

                if (key.equals("obj")) {
                    objValue = (equalsPosition == -1) ? "" : paramString.substring(equalsPosition + 1);
                }
            }

            System.out.println(paramNames.trim());

            if (objValue != null) {
                try {
                    double doubleValue = Double.parseDouble(objValue);
                    alert(doubleValue);
                } catch (NumberFormatException e) {
                    alert(objValue);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}