package com.karthikr;

public class StringUtility {

    static String toSymmetric(String str1, String str2) {
        String str;
        int str1Len = str1.length();
        int str2Len = str2.length();

        if (str1Len < str2Len) {
            str = str2;
        } else {
            str = str1;
        }

        StringBuilder complementaryString = new StringBuilder();

        for (Character character : str.toCharArray()) {
            switch (character) {
                case '[':
                    complementaryString.append("]");
                    break;
                case ']':
                    complementaryString.append("[");
                    break;
                case '{':
                    complementaryString.append("}");
                    break;
                case '}':
                    complementaryString.append("{");
                    break;
                case '(':
                    complementaryString.append(")");
                    break;
                case ')':
                    complementaryString.append("(");
                    break;
            }
        }
        return complementaryString.reverse().toString();
    }

    static Boolean isSymmetric(String str) {
        boolean isItSymmetric;
        isItSymmetric = str.length() % 2 == 0 ? true : false;
        return isItSymmetric;
    }
}
