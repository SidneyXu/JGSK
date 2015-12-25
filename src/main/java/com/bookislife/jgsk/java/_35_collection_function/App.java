package com.bookislife.jgsk.java._35_collection_function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by SidneyXu on 2015/12/25.
 */
public class App {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(10, 20, 30);
        List<List<Integer>> numbers3 = Arrays.asList(numbers1, numbers2);

        //  Stream
        numbers1.stream();
        Stream.of(numbers1);

        //  Map
        Stream<Integer> mapResult = numbers1.stream().map(x -> x * x);
        System.out.println("map => " + getString(mapResult));   //  [1, 4, 9, 16, 25, 36]

        //  FlatMap
        Stream<Integer> flatMapResult = numbers3.stream().flatMap(list -> list.stream().map(x -> x * 10));
        System.out.println("flatMap => " + getString(flatMapResult));   //  [10, 20, 30, 40, 50, 60, 100, 200, 300]

        //  Reduce
        Optional<Integer> reduceResult = numbers1.stream().reduce((n1, n2) -> n1 - n2);
        System.out.println("reduce => " + reduceResult.get());  //  -19

        //  Filter
        Stream<Integer> filterResult = numbers1.stream().filter(n -> n % 2 == 0);
        System.out.println("filter => " + getString(filterResult)); //  [2, 4, 6]

        //  Collect
        Map<Boolean, List<Integer>> collectResult = numbers1.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("collect => " + collectResult);  //  {false=[1, 3, 5], true=[2, 4, 6]}

        //  ForEach
        numbers1.stream().forEach(System.out::println);

        //  Parallel
        numbers1.parallelStream().forEach(System.out::println);
        Stream<Integer> parallelResult = numbers1.parallelStream().map(x -> {
            System.out.println("stream first: " + x + " on " + Thread.currentThread().getName());
            return x;
        }).map(x -> {
            System.out.println("stream second: " + x + " on " + Thread.currentThread().getName());
            return x;
        }).map(x -> {
            System.out.println("stream third: " + x + " on " + Thread.currentThread().getName());
            return x;
        });
        System.out.println(getString(parallelResult));
    }

    private static String getString(Stream stream) {
        return Arrays.toString(stream.toArray());
    }
}
