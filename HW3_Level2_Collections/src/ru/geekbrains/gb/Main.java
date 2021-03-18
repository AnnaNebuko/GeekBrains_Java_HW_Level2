package ru.geekbrains.gb;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String[] words = {"capture","nerve","deck","gear",
        "marriage", "hour", "tread", "row", "cycle", "proportion",
                "panic", "deck", "hour", "cycle", "nerve"};
	    Map<String, Integer> uniqueAndCounted = makeItUniqueAndCounted(words);
        System.out.println(uniqueAndCounted);

        Map<String, List<String>> phonebookMap  = new HashMap<>(){{
            put("Иванов", new ArrayList<>(){{add ("8-550-500-50-50");}});
            put("Петров", new ArrayList<>(){{add ("8-770-700-70-70");}});
            put("Сидоров", new ArrayList<>(){{add ("8-880-800-80-80"); add ("8-990-900-90-90");}});
        }};
        Phonebook phonebook = new Phonebook(phonebookMap);
        System.out.println(phonebook.get("Сидоров"));
        phonebook.add("Кузнецов", new ArrayList<String>(){{add ("8-550-500-50-50");}});
        System.out.println(phonebook.get("Кузнецов"));

    }

    private static Map<String, Integer> makeItUniqueAndCounted(String[] words) {
        Map<String, Integer> uniqueAndCounted = new HashMap<>();

        for ( String word : words ) {
            Integer count = uniqueAndCounted.get(word);
            if (count == null ) {
                count = 0;
            }
            uniqueAndCounted.put(word, count + 1);
        }
        return uniqueAndCounted;
    }
}
