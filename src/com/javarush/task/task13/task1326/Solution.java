package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = new FileInputStream(sc.nextLine());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        List<Integer> nums = new ArrayList<>();
        while (bufferedReader.ready()) {
            String a = bufferedReader.readLine();
            nums.add(Integer.parseInt(a));
        }
        inputStream.close();
        bufferedReader.close();
        Collections.sort(nums);
        for (int a : nums) {
            if (a % 2 == 0)
                System.out.println(a);
        }}}