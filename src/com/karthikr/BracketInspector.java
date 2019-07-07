package com.karthikr;

import java.util.ArrayList;

public class BracketInspector {
    private String description;
    private Boolean isFixed = false;

    public BracketInspector(String description) {
        this.description = description;
    }

    public int simpleMode() {
        int softWrapping = 0;
        int cardboardBox = 0;
        int woddenBox = 0;

        for (Character character : description.toCharArray()) {
            switch (character) {
                case '(':
                case ')':
                    softWrapping++;
                    break;
                case '[':
                case ']':
                    cardboardBox++;
                    break;
                case '{':
                case '}':
                    woddenBox++;
                    break;
            }
        }

        if (softWrapping % 2 != 0 || cardboardBox % 2 != 0 || woddenBox % 2 != 0) {
            return 1;
        } else {
            isFixed = true;
            return 0;
        }
    }

    public String complexMode() {
        String finalDescription = "";
        if (!isFixed) {
            String complementaryString = "";
            ArrayList<String> itemList = new ArrayList<>();
            Boolean flag = false;
            String[] splitByBracket = description.split("B");
            int size = splitByBracket.length;

            String first = splitByBracket[0];
            String last = splitByBracket[size - 1];

            if (!first.equals(last)) {
                complementaryString = StringUtility.toSymmetric(first, last);

                if (first.length() < last.length()) {
                    flag = true;
                    itemList.add(complementaryString);
                } else {
                    itemList.add(first);
                }
            }

            for (int index = 1; index < size - 1; ++index) {
                String str = splitByBracket[index];
                if (!StringUtility.isSymmetric(str)) {
                    int mid = str.length() / 2;

                    System.out.println(str.substring(0, mid));
                    System.out.println(str.substring(mid));
                    System.out.println("---------");

                    String subStringPart1 = str.substring(0, mid);
                    String subStringPart2 = str.substring(mid);

                    String manipString = StringUtility.toSymmetric(subStringPart1, subStringPart2);
                    itemList.add(manipString + subStringPart2);
                } else {
                    itemList.add(str);
                }
            }

            if (flag) {
                itemList.add(last);
            } else {
                itemList.add(complementaryString);
            }

            return String.join("B", itemList);
        } else {
            finalDescription = "The description is already fixed.";
        }
        return finalDescription;
    }
}
