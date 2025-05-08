package design;

import java.util.HashMap;

public class LC_359_LoggerRateLimiter {
    
    /*
     * TC: O(1) - for each call to shouldPrintMessage()
     * SC: O(n) - where n is the number of unique messages
     */
    
    static class Logger {

        HashMap<String, Integer> hmap;

        public Logger() {
            hmap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!hmap.containsKey(message)) {
                hmap.put(message, timestamp + 10);
                return true;
            }

            int savedTimestamp = hmap.get(message);
            if (savedTimestamp <= timestamp) {
                hmap.put(message, timestamp + 10);
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        // Test Case 1: Initial message should print
        System.out.println(logger.shouldPrintMessage(1, "foo")); // true

        // Test Case 2: Message within 10 seconds should not print
        System.out.println(logger.shouldPrintMessage(2, "foo")); // false

        // Test Case 3: Same message after 10 seconds should print
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true

        // Test Case 4: Different message should print immediately
        System.out.println(logger.shouldPrintMessage(3, "bar")); // true

        // Test Case 5: Edge case - large timestamp gap
        System.out.println(logger.shouldPrintMessage(100, "bar")); // true

        // Test Case 6: Repeated message just before 10 seconds
        System.out.println(logger.shouldPrintMessage(109, "foo")); // false
        System.out.println(logger.shouldPrintMessage(110, "foo")); // true
    }
}
