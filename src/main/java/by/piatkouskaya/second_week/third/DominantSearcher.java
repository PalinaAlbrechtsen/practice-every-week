package by.piatkouskaya.second_week.third;

import java.util.HashMap;
import java.util.Map;

public class DominantSearcher {

    private int getDominant(int[] arr) {
        Map<Integer, Integer> arrayValuesCounter = new HashMap<>();
        for (int i : arr) {
            if (arrayValuesCounter.containsKey(i)) {
                arrayValuesCounter.merge(i, 1, Integer::sum);
            } else {
                arrayValuesCounter.put(i, 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : arrayValuesCounter.entrySet()) {
            if (entry.getValue() > arr.length / 2) {
                result = entry.getKey();
            }
        }
        if (result == 0) {
            throw new RuntimeException("Array doesn't have the dominant!");
        }

        return result;
    }
}
