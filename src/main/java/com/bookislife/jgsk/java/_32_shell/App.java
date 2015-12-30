package com.bookislife.jgsk.java._32_shell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by SidneyXu on 2015/11/23.
 */
public class App {

    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("ls -al ..");

            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("exit with " + exitValue);
                return;
            }

            try (InputStream in = process.getInputStream();
                 InputStreamReader isr = new InputStreamReader(in);
                 BufferedReader reader = new BufferedReader(isr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nExecute Script");
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = {"/bin/sh", "-c", "ls -al .. | grep JGSK"};
            Process process = runtime.exec(cmd);

            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("exit with " + exitValue);
                return;
            }

            try (InputStream in = process.getInputStream();
                 InputStreamReader isr = new InputStreamReader(in);
                 BufferedReader reader = new BufferedReader(isr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Console Input
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }
}
