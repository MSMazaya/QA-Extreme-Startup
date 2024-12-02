package com.develogical;

public class QueryProcessor {

    public String process(String query) {

        if (query.contains("plus")) {
            // query = What is 16 plus 79
            String[] words = query.split(" ");
            int num1 = Integer.parseInt(words[2]);
            int num2 = Integer.parseInt(words[4]);
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

        if (query.contains("multiplied")) {
            String newQ = query.replace("?", "");
            String tok[] = newQ.split(" ");
            int mult = 1;

            for(String t: tok) {
                try {
                    mult *= Integer.parseInt(t);
                } catch(Exception e) {

                }
            }

            return "" + mult;
        }

        return "";
    }

}