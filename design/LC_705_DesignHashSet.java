package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC_705_DesignHashSet {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        
        // Test case 1
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(3)); // false

        // Test case 2
        set.add(2);
        System.out.println(set.contains(2)); // true
        set.remove(2);
        System.out.println(set.contains(2)); // false

        // Test case 3
        set.add(10001);
        System.out.println(set.contains(10001)); // true

        // Test case 4
        set.add(0);
        System.out.println(set.contains(0)); // true
        set.remove(0);
        System.out.println(set.contains(0)); // false
    }
}

class MyHashSet {

    List<List<Integer>> arr;
    int numOfBuckets;

    /*
     * Time Complexity: O(1) for add, remove, and contains operations
     * Space Complexity: O(n) for storing the elements in the ArrayList
     */

    public MyHashSet() {
        arr = new ArrayList<>(10001);
        numOfBuckets = 10001;
        for (int i = 0; i < numOfBuckets; i++) {
            arr.add(new LinkedList<>());
        }
    }

    public int getHashValue(int index) {
        return index % 10001;
    }

    public void add(int key) {
        int index = getHashValue(key);
        List<Integer> list = arr.get(index);
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int index = getHashValue(key);
        List<Integer> list = arr.get(index);
        if (list.contains(key)) {
            list.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = getHashValue(key);
        List<Integer> list = arr.get(index);
        return list.contains(key);
    }
}
