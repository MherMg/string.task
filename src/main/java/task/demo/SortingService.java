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

    private Map<Character, Set<String>> groupWords = new TreeMap<>();


    /**
     * Sorting method
     *
     * @return Returns a list of sorted data with recorded groups
     */
    String sortStr(String str) {
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

        return groupWords.toString();
    }

    /**
     * The method of forming the structure of the dictionary in a string
     *
     * @return Returns only groups having more than one item
     */
    public String getContainingMoreThanOneElement() {
        Map<Character, Set<String>> result = new TreeMap<>();
        groupWords.forEach((k, v) -> {
            if (v.size() > 1) {
                result.put(k, v);
            }
        });
        return result.toString();
    }
}
