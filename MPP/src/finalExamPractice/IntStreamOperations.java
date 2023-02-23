package finalExamPractice;import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations
{
    public static void main(String[] args)   //lAMBDA  EXPRESSION  -  A Function
    {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        // display original values
        System.out.print("Original values: ");  // Lambda expression below
        IntStream.of(values)
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        // count, min, max, sum and average of the values
        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n",
                IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n",
                IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n", IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n",
                IntStream.of(values).average().getAsDouble());

        // sum of values with reduce method
        System.out.printf("%nSum via reduce method: %d%n",
                IntStream.of(values)
                        .reduce(0, (x, y) -> x + y));

        // sum of squares of values with reduce method
        System.out.printf("Sum of squares via reduce method: %d%n",
                IntStream.of(values)
                        .reduce(0, (x, y) -> x + y * y));  //Will Not work without
        //the first argument! (JL).

//        (((0 + 3*3) + 10* 10) + 6 * 6) + …


        // product of values with reduce method
        System.out.printf("Product via reduce method: %d%n",
                IntStream.of(values)
                        .reduce(1, (x, y) -> x * y));

        // even values displayed in sorted order
        System.out.printf("%nEven values displayed in sorted order: ");
        IntStream.of(values)
                .filter(value -> value % 2 == 0)  //Predicate returns true/false
                .sorted()
                .forEach(value -> System.out.printf("%d ", value)); //Terminal Op.
//        System.out.println();  Declarative style  WHAT

//        Declarative style  WHAT  -  Functional programming style

        // odd values multiplied by 10 and displayed in sorted order
        System.out.printf(
                "Odd values multiplied by 10 displayed in sorted order: ");
        IntStream.of(values)
                .filter(value -> value % 2 != 0)
                .map(value -> value * 10)
                .sorted()
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        // sum range of integers from 1 to 10, exlusive
        System.out.printf("%nSum of integers from 1 to 9: %d%n",
                IntStream.range(1, 10).sum());

        // sum range of integers from 1 to 10, inclusive
        System.out.printf("Sum of integers from 1 to 10: %d%n",
                IntStream.rangeClosed(1, 10).sum());

    }
} // end class IntStreamOperations

// Program 2: ArraysAndStreams.java
// Demonstrating lambdas and streams with an array of Integers.


 class ArraysAndStreams
{
    public static void main(String[] args)
    {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        // display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        // sort values in ascending order with streams
        System.out.printf("Sorted values: %s%n",
                Arrays.stream(values)
                        .sorted()
                        .collect(Collectors.toList()));

        // values greater than 4
        List<Integer> greaterThan4 =
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .collect(Collectors.toList());
        System.out.printf("Values greater than 4: %s%n", greaterThan4);

        // filter values greater than 4 then sort the results
        System.out.printf("Sorted values greater than 4: %s%n",
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .sorted()
                        .collect(Collectors.toList()));  //This list will go to the
        //toString() method (JL).

        // greaterThan4 List sorted with streams
        System.out.printf(
                "Values greater than 4 (ascending with streams): %s%n",
                greaterThan4.stream()
                        .sorted()
                        .collect(Collectors.toList()));
    }
} // end class ArraysAndStreams


 class ArraysAndStreams2
{
    public static void main(String[] args)
    {
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)//val->val.toUpperCase()
                        .collect(Collectors.toList()));

        // strings greater than "m" (case insensitive) sorted ascending

        System.out.printf("strings greater than m sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // strings greater than "m" (case insensitive) sorted descending
        System.out.printf("strings greater than m sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));
    }
} // end class ArraysAndStreams2

