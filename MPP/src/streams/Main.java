package streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        //////////////////////////////////
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        IntStream.of(values).filter(x -> x % 2 == 0).sorted().forEach(x -> System.out.printf("the value is %d\n", x));

        IntStream.of(values).filter(x -> x % 2 != 0).map(x -> x * 10).sorted().forEach(System.out::println);

        System.out.println(Arrays.toString(values));

        Predicate<Integer> predicate = integer -> integer > 5;

        Arrays.asList(values).parallelStream();
        Arrays.stream(values).parallel();

        List<String> sl = new ArrayList<>();
        sl.add("Bara");
        sl.add("batta");
        sl.add("Hello");
        sl.add("awesome");
        sl.add("sleep");

        sl.stream().filter(e -> e.length() > 4).peek(e -> System.out.printf("filtered value %s\n", e)).collect(Collectors.toList());

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello");
            }
        };

        List<String> tryFill = new ArrayList<>();
        for (int i = 0; i <= 1000000; i++)
            tryFill.add("Hello " + i);

        System.out.println(tryFill.stream().collect(Collectors.toList()).toString());

        IntStream.of(values).reduce(0, Integer::sum);

        System.out.println("Word Count => " + countWords(sl, 'a', 'd', 4));

        Stream strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
        System.out.println(strings.collect(Collectors.joining(" ")));


        //////// //////// Exam Data Streams Example
        List<ExamData> data = new ArrayList<ExamData>();

        data.add(new ExamData("George", 91.3));
        data.add(new ExamData("Tom", 88.9));
        data.add(new ExamData("Rick", 80.0));
        data.add(new ExamData("Harold", 90.8));
        data.add(new ExamData("Ignatius", 60.9));
        data.add(new ExamData("Anna", 77.0));
        data.add(new ExamData("Susan", 87.3));
        data.add(new ExamData("Phil", 99.1));
        data.add(new ExamData("Alex", 84.0));


        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();

        for (ExamData datum : data) doubleSummaryStatistics.accept(datum.getTestScore());

        System.out.println("The Min, Average, and Max Data \n\t -- Min Score: " + doubleSummaryStatistics.getMin() + "\n\t -- Average: " + String.format("%,.2f",doubleSummaryStatistics.getAverage()) + " \n\t -- Max Score: " + doubleSummaryStatistics.getMax());

    }//main

//    public interface Consumere<T>{
//        public void accept(T t);
//    }

    public static int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream().filter(w -> w.length() == len && w.contains("" + c) && !w.contains("" + d)).count();
    }

    List<String> findLetter(List<String> list, String letter) {
        return list.stream().filter(name -> name.startsWith(letter))
                .map(String::toUpperCase).collect(Collectors.toList());
    }

}
