package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {

        if (query.contains("minus")) {
            // query = What is 16 minus 79?
            String[] words = query.split(" ");
            int num1 = Integer.parseInt(words[2]);
            int num2 = Integer.parseInt(words[4].substring(0, words[4].length() - 1));
            return String.valueOf(num1 - num2);
        }

        if (query.contains("plus")) {
            // query = What is 16 plus 79?
            String[] words = query.split(" ");
            int num1 = Integer.parseInt(words[2]);
            int num2 = Integer.parseInt(words[4].substring(0, words[4].length() - 1));
            return String.valueOf(num1 + num2);
        }

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.contains("your name")) {
            return "STM33";

        }

        if (query.contains("largest")) {
            String numberQuery = query.substring("Which of the following numbers is the largest: ".length(), query.length()-1);
            List<Integer> numbers = Arrays.asList(numberQuery.split(",")).stream().map(
                s -> Integer.parseInt(s.strip())
            ).toList();
            Integer result = -1;
            for (Integer i : numbers) {
                if (result < i) {
                    result = i;
                }
            }
            return result.toString();
        }

        if (query.contains("multiplied")) {
            List<Integer> integers = new ArrayList<>();
            StringBuilder number = new StringBuilder();

            for (char c : query.toCharArray()) {
                if (Character.isDigit(c)) {
                    number.append(c);
                } else if (number.length() > 0) {
                    integers.add(Integer.parseInt(number.toString()));
                    number.setLength(0);
                }
            }

            if (number.length() > 0) {
                integers.add(Integer.parseInt(number.toString()));
            }

            Integer result = integers.get(1) * integers.get(0);
            return result.toString();
        }
        return "";
    }

}