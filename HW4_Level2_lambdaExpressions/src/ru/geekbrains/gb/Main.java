package ru.geekbrains.gb;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        //===Task1===
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);
        //doTask1(); пример решения с урока
        //===Task2===
        Set<String> words = Set.of("a", "b", "c", "d", "e");
        forItem(words, System.out::println);
        //===Task3===
        Supplier<Integer>num = () -> 2;
        System.out.println(doubleUp(9, num));
        //===Task4===
        Optional opt = findAllChars("Waiting for the summer",'f');
        System.out.println(opt.get());
    }

    private static void doTask1() {
        List<Integer>numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.forEach(integer -> System.out.println(integer));
    }

    public static void forItem(Set<String> set, Consumer<String> consumer){
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String val = iterator.next();
            consumer.accept(val);
        }
        //Предложение от IDEA
//        for (String val : set) {
//            consumer.accept(val);
//        }
    }
    public static int doubleUp(int i, Supplier<Integer> supplier){
        return i * supplier.get();
    }

    //Списано, но понято:)
    public static Optional <String> findAllChars(String target, char toFind){
        char[] chars = target.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == toFind) {
                sb.append(toFind);
            }
        }

        if (sb.length() > 0) {
            return Optional.of(sb.toString());
        }

        return Optional.empty();
    }
}
