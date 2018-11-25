package by.piatkouskaya.second_week.fourth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySorter {

    private int[] sortUnevenArrayValues(int[] arr) {
        List<Integer> unevenDigits = new ArrayList<>();
        Arrays.stream(arr)
                .filter(it -> it % 2 != 0)
                .forEach(unevenDigits::add);
        Collections.sort(unevenDigits);
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = unevenDigits.get(j);
                j++;
            }
        }

        return arr;
    }
}
