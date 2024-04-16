package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;
    public static void main(String[] args) {
      Solution solution = new Solution();
        System.out.println(solution.intVar);
        System.out.println(solution.doubleVar);
        System.out.println(solution.DoubleVar);
        System.out.println(solution.booleanVar);
        System.out.println(solution.ObjectVar);
        System.out.println(solution.ExceptionVar);
        System.out.println(solution.StringVar);








    }

    public int getIntVar() {
        return intVar;
    }

    public double getDoubleVar() {
        return doubleVar;
    }

    public boolean isBooleanVar() {
        return booleanVar;
    }

    public Object getObjectVar() {
        return ObjectVar;
    }

    public Exception getExceptionVar() {
        return ExceptionVar;
    }

    public String getStringVar() {
        return StringVar;
    }
}
