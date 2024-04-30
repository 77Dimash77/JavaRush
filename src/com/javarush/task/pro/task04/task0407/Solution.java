package com.javarush.task.pro.task04.task0407;

/* 
Сумма чисел, не кратных 3
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int a = 0;
        int result = 0;
while(a<=99){
    a++;
    if((a % 3) == 0){
        continue;
    }
    result = result + a;
    
}
System.out.println(result);
    }
}