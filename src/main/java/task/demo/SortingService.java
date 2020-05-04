package task.demo;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by
 * Mher Petrosyan
 * Email mher13.02.94@gmail.ru
 */
@Service
public class SortingService {

    void sortStr(String str) {
        Map<Character, Set<String>> groupWords = new TreeMap<>();
        String[] words = str.toLowerCase().split(" ");
        for (String word : words) {
            char key = word.charAt(0);
            Comparator<String> comparator = (s1, s2) -> {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s2.length() - s1.length();
                }
            };
            Set<String> value = new TreeSet<>(comparator);
            if (groupWords.containsKey(key)) {
                value = groupWords.get(key);
            }
            value.add(word);
            groupWords.put(key, value);

        }

        System.out.println(groupWords.toString());
    }
}
