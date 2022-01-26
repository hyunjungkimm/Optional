package Default;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Default {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);//[1, 2, 3, 5, 6]
    }
}
