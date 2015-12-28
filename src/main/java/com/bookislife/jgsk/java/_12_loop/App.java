package com.bookislife.jgsk.java._12_loop;

import java.util.Arrays;

/**
 * Created by SidneyXu on 2015/09/19.
 */
public class App {

    public static void main(String[] args) {
        testFor();
        testWhile();
        testBreakAndContinue();
    }

    private static void testFor() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Repeat For " + i);
        }

        int[] arr = {1, 2, 3};
        for (int a : arr) {
            System.out.println("Repeat For-Each " + a);
        }
    }

    private static void testWhile() {
        int[] arr = {1, 2, 3};
        int i = 0;
        while (i < arr.length) {
            System.out.println("Repeat While " + arr[i++]);
        }

        i = 0;
        do {
            i++;
            System.out.println("Repeat Do-While " + i);
        } while (i < 5);
    }

    private static void testBreakAndContinue() {
        for (int i : Arrays.asList(1, 2, 3, 4, 5)) {
            if (i == 3) continue;
            System.out.println("Continue " + i);    //  1 2 4 5
        }
        for (int i : Arrays.asList(1, 2, 3, 4, 5)) {
            if (i == 3) break;
            System.out.println("Break " + i);   //  1 2
        }
    }
}
