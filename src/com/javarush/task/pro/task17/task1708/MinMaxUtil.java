package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

public class MinMaxUtil {
    //напишите тут ваш код
   static public int min(int a, int b) {
        if (a > b) {
            return b;
        } else return a;
    }
   static public int min(int a, int b, int c) {

        return Collections.min(Arrays.asList(a, b, c));
    }
   static public int min(int a, int b,int c, int d) {
       return Collections.min(Arrays.asList(a, b, c, d));
    }
  static   public int min(int a,int b,int c,int d,int e) {
      return Collections.min(Arrays.asList(a, b, c, d, e));
    }
    static public int max(int a, int b) {
        if (a > b) {
            return a;
        } else return b;
    }
    static public int max(int a, int b, int c) {

        return Collections.max(Arrays.asList(a, b, c));
    }
    static public int max(int a, int b,int c, int d) {
        return Collections.max(Arrays.asList(a, b, c, d));
    }
    static   public int max(int a,int b,int c,int d,int e) {
        return Collections.max(Arrays.asList(a, b, c, d, e));
    }
}