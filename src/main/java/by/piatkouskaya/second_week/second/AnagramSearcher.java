package by.piatkouskaya.second_week.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramSearcher {

    private static List<List<String>> getAnagrams(String[] words) {
        HashMap<String, List<String>> matchMap = new HashMap<>();
        for (String word : words) {
            String key = getKey(word);
            if (!matchMap.containsKey(key)) {
                matchMap.put(key, new ArrayList<>());
            }
            matchMap.get(key).add(word);
        }

        return new ArrayList<>(matchMap.values());
    }

    private static String getKey(String word) {
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

