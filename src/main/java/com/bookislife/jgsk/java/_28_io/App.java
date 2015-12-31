package com.bookislife.jgsk.java._28_io;

import java.io.*;

/**
 * Created by SidneyXu on 2015/10/18.
 */
public class App {

    public static void main(String[] args) {
        String filepath = "files/test.txt";

        File file = new File(filepath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
        }

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file, true);
            outputStream.write("hello java".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write("hello java".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String result;
            StringBuilder stringBuilder = new StringBuilder();
            while ((result = bufferedReader.readLine()) != null) {
                stringBuilder.append(result);
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
