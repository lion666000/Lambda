package lambdy.dil03;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

public class Lekce03 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
//        ukazkaConsumer();
//        ukazkaPredikaty();
//        ukazkaSupplier();
//        consumer();
//        interval();
//        transformace();
        dodavatele();
        // pozdrav();
        // jmena();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaConsumer() {
        // TODO ukazka: postupuj podle pracovniho snimku.

        Consumer<String> print = text -> System.out.println(text);
        print.accept("Hello");

        Consumer<String> lenght = s -> System.out.println(s.length());
        Consumer<String> both = print.andThen(lenght);
        both.accept("Java");

    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaPredikaty() {
        // TODO ukazka: postupuj podle pracovniho snimku.

        Predicate<Integer> positive = x -> x > 0;
        Predicate<Integer> even = x -> x % 2 == 0;
        System.out.println(positive.test(1));
        System.out.println(even.test(2));
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaSupplier() {
        // TODO ukazka: postupuj podle pracovniho snimku.

        Supplier<Double> random = () -> Math.random();
        double a = random.get();
        double b = random.get();
        System.out.println(a);
        System.out.println(b);
    }

    // Uloha 3.1. Čtyři řádky: Java, 4, prázdný řádek, 0.
    static void consumer() {
        // TODO 3.1: Consumer. Zde pis sve reseni.

        Consumer<String> print = text -> System.out.println(text);
        print.accept("Hello");

        Consumer<String> lenght = s -> System.out.println(s.length());
        Consumer<String> both = print.andThen(lenght);
        both.accept("Java");
        both.accept("");
    }

    // Uloha 3.2. inRange: false, true, true, false. outside má vždy opačný výsledek.
    static void interval() {
        int[] values = {10, 11, 100, 101};
        // TODO 3.2: Interval (10, 100]. Zde pis sve reseni.

        Predicate<Integer> above10 = x -> x > 10;
        Predicate<Integer> atMost100 = x -> x <= 100;
        Predicate<Integer> inRange = above10.and(atMost100);
        Predicate<Integer> outside = inRange.negate();

        for (int n : values) {
            System.out.println(n + ": " + inRange.test(n) + ", " + outside.test(n)) ;
        }


    }

    // Uloha 3.3. Vysledek: JAVA / Vysledek: s koncovou mezerou / Java.
    static void transformace() {
        // TODO 3.3: Skládání Function. Zde pis sve reseni.

        Function<String, String> strip = s -> s.strip();
        Function<String, String> upper = s -> s.toUpperCase(Locale.ROOT);
        Function<String, String> prefix = s -> "Vysledek: " + s;
        Function<String, String> all = strip.andThen(upper).andThen(prefix);
        Function<String, String> same = Function.identity();

        System.out.println(all.apply(" java "));
        System.out.println(all.apply("   "));
        System.out.println(same.apply("Java"));
    }

    // Uloha 3.4. Pevné testy: vyborne, nedostatecne, 09:05. Náhodná známka i aktuální čas se mění.
    static void dodavatele() {
        // TODO 3.4: Známka a čas. Zde pis sve reseni.

        IntFunction<String> describe = grade -> switch(grade){
            case 1 -> "vyborne";
            case 2 -> "chvalitebne";
            case 3 -> "dobre";
            case 4 -> "dostatecne";
            case 5 -> "nedostatecne";
            default -> throw new IllegalArgumentException("znamka");
        };

        System.out.println(describe.apply(1));
        System.out.println(describe.apply(5));
        Supplier<String> grade = () -> describe.apply(1 + (int) (Math.random() * 5)
        );
        System.out.println(grade.get());

        DateTimeFormatter hhmm = DateTimeFormatter.ofPattern("HH:mm");
        Supplier<String> time = () -> LocalTime.now().format(hhmm);
        System.out.println(time.get());
        System.out.println(LocalTime.of(9, 5).format(hhmm));
    }

    // Uloha 3.5. Celkem tři řádky Ahoj; volání s nulou nic nepřidá.
    static void pozdrav() {
        // TODO 3.5: Vlastní Greeting. Zde pis sve reseni.
    }

    // Uloha 3.6. Výpis ADAM a ALENA. Pro prázdný seznam žádný výpis.
    static void jmena() {
        List<String> names = List.of("Eva", "", "Adam", "Alena");
        // TODO 3.6: Zpracování jmen. Zde pis sve reseni.
    }
}
