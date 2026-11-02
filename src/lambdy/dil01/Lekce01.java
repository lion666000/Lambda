package lambdy.dil01;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

public class Lekce01 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
    //    ukazkaRunnable();
    //    runnablePrinter();
    //    spojeni();
    //    kalkulacka();
    //    porovnaniDelek();
        formatovani();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaRunnable() {
        /*
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ahoj");
            }
        };
        task.run();

         */
        // TODO ukazka: postupuj podle pracovniho snimku.

        Runnable task = () -> System.out.println("Ahoj");
        task.run();
    }

    // Uloha 1.1. Tři řádky: Welcome, Java a prázdný řádek.
    static void runnablePrinter() {
        // TODO 1.1: Runnable a Printer. Zde pis sve reseni.
        Runnable task = () -> System.out.println("Welcome");
        Printer printer = (String text) -> System.out.println(text);
        task.run();
        printer.print("Java");
        printer.print("");




    }

    // Uloha 1.2. Výpis AB a B. Prázdný řetězec nezpůsobí chybu.
    static void spojeni() {
        // TODO 1.2: Vlastní Concatenator. Zde pis sve reseni.
        Concatenator concatenator = (String a, String b) -> a + b;
        System.out.println(concatenator.concat("A", "B"));
        System.out.println(concatenator.concat("", "B"));
    }

    // Uloha 1.3. Pro (10, 4): 14, 40, 6. Pro (-2, 0): -2, 0, -2.
    static void kalkulacka() {
        // TODO 1.3: Tři operace. Zde pis sve reseni.
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;

        System.out.println(add.compute(1, 2));
        System.out.println(multiply.compute(1, 2));
        System.out.println(subtract.compute(1, 2));

    }

    // Uloha 1.4. Znaménka výsledků jsou záporné, záporné, nula.
    static void porovnaniDelek() {
        // TODO 1.4: Porovnání délek. Zde pis sve reseni.

        Comparator<String> comparator = (a, b) -> Integer.compare(a.length(), b.length());

        System.out.println(comparator.compare("pes", "kocka"));
        System.out.println(comparator.compare("", "a"));
        System.out.println(comparator.compare("pes", "les"));
    }

    // Uloha 1.5. Pro Tom: Hello, Tom / WELCOME, TOM / User: Tom. Pro prázdné jméno zůstane jen prefix.
    static void formatovani() {
        // TODO 1.5: MessageFormatter. Zde pis sve reseni.
        MessageFormatter formatter1 = (text) -> String.format("Hello, " + text);
        MessageFormatter formatter2 = (text) -> String.format("WELCOME, " + text.toUpperCase());
        MessageFormatter formatter3 = (text) -> String.format("User: " + text);
        System.out.println(formatter1.format("Tom"));
        System.out.println(formatter1.format(""));
        System.out.println(formatter2.format("Tom"));
        System.out.println(formatter2.format(""));
        System.out.println(formatter3.format("Tom"));
        System.out.println(formatter3.format(""));
    }
}
