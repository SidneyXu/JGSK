package com.bookislife.jgsk.java._25_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SidneyXu on 2015/10/10.
 */
public class App {

    public static void main(String[] args) {
        String input = "99 bottles, 98 bottles";

        //  Pattern
        Pattern pattern = Pattern.compile("[0-9]+\\W");

        //  Matching
        if ("Hello".matches("[A-Z][a-z]+")) {
            System.out.println("ok");
        }

        //  Searching
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("find all " + matcher.group());  //  99  98
        }

        //  group
        //  named group
        Matcher dateMatcher = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})").matcher("2015-10");
        if (dateMatcher.matches()) {
            System.out.println(dateMatcher.group("year"));  //  2015
            System.out.println(dateMatcher.group("month")); //  10
            System.out.println(dateMatcher.groupCount());   //  2
            //  <= not <
            for (int i = 0; i <= dateMatcher.groupCount(); i++) {
                System.out.println(dateMatcher.group(i));   //  [2015-10, 2015, 10]
            }
        }


        //  Replacing
        String result = matcher.replaceFirst("xxx");
        System.out.println(result);    //  xxxbottles, 98 bottles
    }
}
