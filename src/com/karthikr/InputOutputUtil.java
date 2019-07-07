package com.karthikr;

import java.util.Scanner;

class InputOutputUtil {

    static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    static void outputString(String str) {
        System.out.println(str);
    }
}