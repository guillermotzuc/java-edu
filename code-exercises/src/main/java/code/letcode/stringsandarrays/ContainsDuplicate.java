package code.letcode.stringsandarrays;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        System.out.print(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {

       Map<Integer, List<Integer>> map = IntStream.of(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()));

       return map.entrySet().stream()
               .anyMatch(e -> e.getValue().size() >= 2);

    }

}
