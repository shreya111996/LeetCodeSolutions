package design;

import java.util.LinkedList;
import java.util.Queue;

public class LC_346_MovingAveragefromDataStream {

    /*
     * TC: O(1) - for each call to next()
     * SC: O(n) - where n is the size of the queue
     * 
     */

    static class MovingAverage {

        Queue<Integer> q;
        int len;
        double sum;

        public MovingAverage(int size) {
            q = new LinkedList<>();
            len = size;
            sum = 0;
        }

        public double next(int val) {
            if (q.size() == len) {
                sum -= q.poll();
            }

            q.offer(val);
            sum += val;

            return sum / q.size();
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Window size = 3
        MovingAverage m1 = new MovingAverage(3);
        System.out.println(m1.next(1)); // 1.0
        System.out.println(m1.next(10)); // (1 + 10)/2 = 5.5
        System.out.println(m1.next(3)); // (1 + 10 + 3)/3 = 4.666...
        System.out.println(m1.next(5)); // (10 + 3 + 5)/3 = 6.0

        // Test Case 2: Window size = 1
        MovingAverage m2 = new MovingAverage(1);
        System.out.println(m2.next(100)); // 100.0
        System.out.println(m2.next(-100)); // -100.0

        // Test Case 3: Edge case - zero value
        MovingAverage m3 = new MovingAverage(2);
        System.out.println(m3.next(0)); // 0.0
        System.out.println(m3.next(4)); // 2.0
        System.out.println(m3.next(0)); // 2.0
    }
}
