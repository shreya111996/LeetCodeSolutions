package binarysearch;

import java.util.*;

public class LC_729_MyCalendarI {

    /*
     * TC: O(log n) - where n is the number of bookings - for each call to book()
     * SC: O(n) - for the TreeMap to store the bookings
     */

    static class MyCalendar {

        TreeMap<Integer, Integer> bookingMap;

        public MyCalendar() {
            bookingMap = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {

             /* only two conflicts may arise, 
        endTime(prev) <= startTime(new)
        startTime(next) >= endTime(new) */


            Integer prev = bookingMap.floorKey(startTime);
            Integer next = bookingMap.ceilingKey(startTime);

            if ((prev == null || bookingMap.get(prev) <= startTime) &&
                    (next == null || endTime <= next)) {

                bookingMap.put(startTime, endTime);
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();

        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(15, 25)); // false, overlaps with [10, 20)
        System.out.println(calendar.book(20, 30)); // true, no overlap
        System.out.println(calendar.book(5, 10));  // true, no overlap
        System.out.println(calendar.book(5, 15));  // false, overlaps with [10, 20)
        System.out.println(calendar.book(30, 40)); // true
        System.out.println(calendar.book(25, 35)); // false, overlaps with [20, 30)
        System.out.println(calendar.book(40, 50)); // true
    }
}
