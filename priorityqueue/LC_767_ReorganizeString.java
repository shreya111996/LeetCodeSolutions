package priorityqueue;

import java.util.*;

public class LC_767_ReorganizeString {

    /*
     * TC: O(n log n) - where n is the length of the input string
     * SC: O(n) - for the frequency map and priority queue
     */

    public static String reorganizeString(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) > ((n + 1) / 2)) {
                return "";
            }
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> element : freq.entrySet()) {
            pq.offer(new Pair<>(element.getKey(), element.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair<Character, Integer> element1 = pq.poll();
            Pair<Character, Integer> element2 = pq.poll();

            sb.append(element1.getKey());
            int freq1 = element1.getValue() - 1;
            if (freq1 > 0) {
                pq.offer(new Pair<>(element1.getKey(), freq1));
            }

            if (element2 != null) {
                sb.append(element2.getKey());
                int freq2 = element2.getValue() - 1;
                if (freq2 > 0) {
                    pq.offer(new Pair<>(element2.getKey(), freq2));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(reorganizeString("aab"));      // Possible output: "aba"
        System.out.println(reorganizeString("aaab"));     // Output: "" (Not possible)
        System.out.println(reorganizeString("vvvlo"));    // Output: e.g. "vlvov" or similar
        System.out.println(reorganizeString(""));         // Output: ""
        System.out.println(reorganizeString("a"));        // Output: "a"
        System.out.println(reorganizeString("aa"));       // Output: "" (Not possible)
        System.out.println(reorganizeString("aabbcc"));   // Output: e.g. "abcabc", "acbacb", etc.
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}