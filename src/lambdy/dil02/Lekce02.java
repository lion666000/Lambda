package lambdy.dil02;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

public class Lekce02 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
//        ukazkaSoucet();
//        ukazkaSlova();
//        ukazkaDuplicity();
        delkySlov();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaSoucet() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
        // TODO ukazka: postupuj podle pracovniho snimku.

        int streamSum = IntStream.rangeClosed(1, 100).sum();
        System.out.println(streamSum);
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaSlova() {

        List<String> words = List.of("Ahoj", "svete", "", "Afrika", "Java");

        for (String word : words) {
            if (word.startsWith("A")) {
                System.out.println(word);
            }
        }

        // TODO ukazka: postupuj podle pracovniho snimku.

        words.stream()
                .filter(word -> word.startsWith("A"))
                .forEach(word -> System.out.println(word));
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaDuplicity() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 1);
        // TODO ukazka: postupuj podle pracovniho snimku.
        List<Integer> unique = new  ArrayList<>();

        for (int n :numbers) {
            if (!unique.contains(n)) {
                unique.add(n);
            }
        }

        System.out.println(unique);

        List<Integer> uniqueStream = numbers.stream()
                .distinct()
                .toList();
        System.out.println(uniqueStream);
    }

    // Uloha 2.1. Připravený vstup dá [4, 6], prázdný vstup [].
    static void delkySlov() {
        List<String> input = List.of("Ahoj", "", "Afrika", "Java", "Ahoj");
        // TODO 2.1: Délky vybraných slov. Zde pis sve reseni.

        List<Integer> lenghts = input.stream().filter(word -> word.startsWith("A"))
                .distinct()
                .map(word -> word.length())
                .toList();
        System.out.println(lenghts);
    }
}
