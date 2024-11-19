package Java8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreamsDemo {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        IntStream stream = Arrays.stream(nums);

        List<Integer> collect = IntStream.range(1, 5).boxed().collect(Collectors.toList());

        IntStream.of(1,2,3,4);

        DoubleStream doubles = new Random().doubles(5);
        System.out.println(doubles.sum());
//        System.out.println(doubles.average());
//        System.out.println(doubles.max());
//        System.out.println(doubles.min());
//        System.out.println(doubles.count());
//        System.out.println(doubles.summaryStatistics());
//        System.out.println(doubles.boxed().toList());

        List<Integer> list2 = new Random().ints(5).boxed().toList();
        System.out.println(list2);

    }
}
