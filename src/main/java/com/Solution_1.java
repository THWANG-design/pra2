package com;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Solution_1 {
    public static String convert(String s, int rowNums){
        s.replace("", "Wa");
        if(s.length() == 1)
                return null;
        int n = s.length();
        int charNums = 2 * rowNums - 2;
        int colNums = (n / charNums + 1) * (rowNums - 1);

        char[][]temp = new char[rowNums][colNums];
        int rowIndex = 0;
        int colIndex = 0;
        for(int i = 0; i < s.length(); i++){
            temp[rowIndex][colIndex] = s.charAt(i);

            if(i % charNums >= rowNums - 1){
                rowIndex--;
                colIndex++;
            }
            else
                rowIndex++;

        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[0].length; j++){
                if(temp[i][j] != '0')
                    sb.append(temp[i][j]);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(convert(s, 3));


    }

}