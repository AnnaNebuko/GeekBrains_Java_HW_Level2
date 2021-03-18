package ru.geekbrains.gb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> phonebookMap;

    public Phonebook(Map<String, List<String>> phonebookMap) {
        this.phonebookMap = phonebookMap;
    }

    public List<String> get(String lastName) {
        return phonebookMap.get(lastName)==null? new ArrayList<>():phonebookMap.get(lastName);
    }

    public void add(String lastName, ArrayList<String> numbers) {
        if (phonebookMap.containsKey(lastName)){
            phonebookMap.get(lastName).addAll(numbers);
        } else {
            phonebookMap.put(lastName, numbers);
        }
    }
}
