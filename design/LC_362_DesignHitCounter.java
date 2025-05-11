package design;

import java.util.*;

public class LC_362_DesignHitCounter {

    /*
     * TC: O(1) for hit() and O(n) for getHits() - where n is the number of hits
     * SC: O(n) - for storing the hits in a queue
     */

    static class HitCounter {

        Queue<Integer> q;

        public HitCounter() {
            q = new LinkedList<>();
        }

        public void hit(int timestamp) {
            q.offer(timestamp);
        }

        public int getHits(int timestamp) {

            /*
             * If timestamp = 301, then:
             * We want to count hits that occurred from 302 - 300 = 2 to 301.
             * So, any hit at timestamp <= 1 should be removed
             */
            // Remove hits that occurred more than 300 seconds ago
            while (!q.isEmpty() && q.peek() <= timestamp - 300) {
                q.poll();
            }
            return q.size();
        }
    }

    public static void main(String[] args) {

        HitCounter counter = new HitCounter();

        // Test case 1: basic functionality
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4)); // Expected: 3

        // Test case 2: hits at exact boundary
        counter.hit(300);
        System.out.println(counter.getHits(300)); // Expected: 4
        System.out.println(counter.getHits(301)); // Expected: 3 (hit at 1 should be out)

        // Test case 3: no hits
        HitCounter counter2 = new HitCounter();
        System.out.println(counter2.getHits(100)); // Expected: 0

        // Test case 4: large gap, all hits expired
        counter2.hit(1);
        counter2.hit(2);
        counter2.hit(3);
        System.out.println(counter2.getHits(305)); // Expected: 0

        // Test case 5: multiple hits at the same time
        HitCounter counter3 = new HitCounter();
        counter3.hit(100);
        counter3.hit(100);
        counter3.hit(100);
        System.out.println(counter3.getHits(100)); // Expected: 3
        System.out.println(counter3.getHits(400)); // Expected: 0
    }
}
