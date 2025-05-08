package design;

import java.util.*;

public class LC_706_DesignHashMap {

    /*
     * TC: O(1) for put, get, and remove operations
     * SC: O(n) for storing the elements in the ArrayList
     * where n is the number of elements in the HashMap
     */

    static class MyHashMap {

        List<List<Pair<Integer, Integer>>> arr;

        public MyHashMap() {
            arr = new ArrayList<>(1000);
            for (int i = 0; i < 1000; i++) {
                arr.add(new ArrayList<>());
            }
        }

        public void put(int key, int value) {
            int index = hashFunc(key);
            List<Pair<Integer, Integer>> listOfPairs = arr.get(index);
            Iterator<Pair<Integer, Integer>> pairItr = listOfPairs.iterator();

            while (pairItr.hasNext()) {
                if (pairItr.next().getKey().equals(key)) {
                    pairItr.remove();
                    break;
                }
            }

            listOfPairs.add(new Pair<>(key, value));
        }

        public int get(int key) {
            int index = hashFunc(key);
            List<Pair<Integer, Integer>> listOfPairs = arr.get(index);

            for (Pair<Integer, Integer> pair : listOfPairs) {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }

            return -1;
        }

        public void remove(int key) {
            int index = hashFunc(key);
            List<Pair<Integer, Integer>> listOfPairs = arr.get(index);
            Iterator<Pair<Integer, Integer>> pairItr = listOfPairs.iterator();

            while (pairItr.hasNext()) {
                if (pairItr.next().getKey().equals(key)) {
                    pairItr.remove();
                    break;
                }
            }
        }

        public int hashFunc(int idx) {
            return idx % 1000;
        }

        // Helper class to simulate Pair (since JavaFX isn't always available)
        static class Pair<K, V> {
            private final K key;
            private final V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Put key-value pairs
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(3)); // -1 (not found)

        // Update value
        map.put(2, 20);
        System.out.println(map.get(2)); // 20

        // Remove key
        map.remove(2);
        System.out.println(map.get(2)); // -1 (removed)

        // Edge case: remove non-existing key
        map.remove(5); // should not error

        // Large key (to test hash collision)
        map.put(1001, 10); // same bucket as key=1
        map.put(2001, 20);
        System.out.println(map.get(1001)); // 10
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2001)); // 20
    }
}
