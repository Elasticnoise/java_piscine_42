package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Main {

    public static  void createWordsMap(String fileName, Map<String, Integer> map) {
        String[] words;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/com/company/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words = line.split("\\s");
                for (String word : words) {
                    map.putIfAbsent(word, 0);
                }
            }
            mapToFile(map);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vector<Integer> getWordsCountArray(String fileName, Map<String, Integer> map) {
        String[] words;
        Vector<Integer> vec = new Vector<>();

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            entry.setValue(0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/com/company/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words = line.split("\\s");
                for (String word : words) {
                    if (map.containsKey(word)) {
                        map.replace(word, map.get(word) + 1);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        for (Integer count : map.values()) {
            vec.add(i, count);
            i++;
        }
        return vec;
    }

    public static double getSimilarity(Vector<Integer> A, Vector<Integer> B)
    {
        double dot_product = 0.0;
        double norm_a = 0.0;
        double norm_b = 0.0;

        for (int i = 0; i < A.size(); i++) {
            dot_product += A.get(i) * B.get(i);
            norm_a += Math.pow(A.get(i), 2);
            norm_b += Math.pow(B.get(i), 2);
        }
        return dot_product / (Math.sqrt(norm_a) * Math.sqrt(norm_b));
    }

    public static void mapToFile(Map<String, Integer> map) {
        File file = new File("dictionary.txt");
        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                bf.write(entry.getKey() + ":"
                    + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert bf != null;
                bf.close();
            }
            catch (Exception ignored) {

            }
        }
}

    public static void main(String[] args) {
        if (args != null) {
            Vector<Integer> A;
            Vector<Integer> B;
            String firstFile = args[0];
            String secondFile = args[1];
            Map<String, Integer> map = new HashMap<>();

            createWordsMap(firstFile, map);
            createWordsMap(secondFile, map);
            A = getWordsCountArray(firstFile, map);
            B = getWordsCountArray(secondFile, map);
            System.out.println("Similarity = " + getSimilarity(A, B));
//            for (Integer integer : A) {
//                System.out.print(integer + " ");
//            }
//            System.out.println("");
//            for (Integer integer : B) {
//                System.out.print(integer + " ");
//            }
//            for (Map.Entry<String, Integer> entry: map.entrySet())
//                System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
