package jxuan95;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-21.
 * 百度前端笔试第三题
 */
public class Baidu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int testNum = in.nextInt();
            for (int i = 0; i < testNum; i++) {
                String data = in.next();
                if (isRC(data)) {//RC格式
                    String result = changeToNo(data);
                    System.out.println(result);
                } else {//非RC格式
                    String result = changeToRC(data);
                    System.out.println(result);
                }
            }
        }
    }

    private static String changeToRC(String data) {

        return null;
    }

    private static String changeToNo(String data) {
        String result = "";
        int one, two, three, four, five;
        char on, tw, th, fo, fi;

        String numberLast = data.substring(data.indexOf("R") + 1, data.indexOf("C"));
        String toChangeStr = data.substring(data.indexOf("C") + 1);
        int numberNum = Integer.valueOf(toChangeStr);

        if (numberNum > Math.pow(26, 4)) {

        } else if (numberNum > Math.pow(26, 3)) {

        } else if (numberNum > Math.pow(26, 2)) {

        } else if (numberNum > Math.pow(26, 1)) {
            one = numberNum / 26;
            one += 64;
            on = (char) one;
            one = numberNum % 26;
            one += 64;
            tw = (char) one;
            result = on + tw + "";

        } else {
            numberNum += 64;
            on = (char) numberNum;
            result = on + "";
        }
        return result;
    }

    private static boolean isRC(String data) {
        if (data.contains("R")) {
            if (data.contains("C")) {
                try {
                    char number = data.substring(data.indexOf("R") + 1, data.indexOf("C")).charAt(0);
                    if (number >= 48 && number <= 57) {
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}
