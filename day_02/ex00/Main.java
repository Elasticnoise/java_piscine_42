package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static Map<String, String> createFileMap() throws IOException {
        String FILE_PATH = "src/com/company/signatures.txt";
        Scanner typeScanner = new Scanner(new File(FILE_PATH));
        Map<String, String> map = new HashMap<>();

        while (typeScanner.hasNext()) {
            String nextLine = typeScanner.nextLine();
            String[] data = nextLine.split(",");
            for (int i = 1; i < data.length; i++) {
                map.put(data[i], data[i-1]);
            }
        }
        return map;
    }

    public static String fileQualifier(String file_path, Map<String, String> map) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file_path);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }
        int i = 0, count = 0;
        String result = "";
        String find = null;

        while (true) {
            try {
                if ((i = fileInputStream.read()) == -1 || count >= 12)
                    break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            result += String.format(" %02X", i);
            find = map.get(result);
            if (find != null)
                break;
            count++;
        }
        return find;
    }

    public static void recordResult(List<String> list) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("result.txt", false);
        byte[] bytes;

        for (String s : list) {
            bytes = s.getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(bytes);
            fileOutputStream.write('\n');
        }
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        String file_path;
        String result;
        Scanner scan = new Scanner(System.in);

        System.out.print("-> ");
        while (true) {
            file_path = scan.next();
            if (file_path.equals("42")) {
                System.out.println("Bye-Bye");
                break;
            }
            try {
                result = fileQualifier(file_path, crdeateFileMap());
                if (result == null)
                    System.out.println("UNDEFINED");
                else {
                    System.out.println("PROCESSED");
                    list.add(result);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.print("-> ");
        }
        recordResult(list);
    }
}
