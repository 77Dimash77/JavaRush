package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных
*/

public class Solution {
    static {
        init();
    }
    static {
        System.out.println("Static block");
    }
    public static void main(String[] args) {
        System.out.println("public static void main");

        Solution s = new Solution();
    }


    {
        System.out.println("Non-static block");
        printAllFields(this);
    }
    public String name = "First name";
    public int i = 6;





    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }



    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);

    }
}
