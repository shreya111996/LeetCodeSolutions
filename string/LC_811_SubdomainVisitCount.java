package string;

import java.util.*;

public class LC_811_SubdomainVisitCount {

    private static void putInMap(Map<String, Integer> reps, String key, Integer value) {
        reps.put(key, reps.getOrDefault(key, 0) + value);
    }

    /* 
     * TC: O(n * m) - where n is the number of cpdomains and m is the average length of each domain
     * SC: O(n) - we use a map to store the counts of each subdomain
     */

    public static List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> reps = new HashMap<>();

        for (String domain : cpdomains) {

            String[] parts = domain.split(" ");
            String n = parts[0];
            int num = Integer.parseInt(n);

            putInMap(reps, parts[1], num);

            String[] split = parts[1].split("\\.");

            if (split.length == 3) {

                StringBuilder sb = new StringBuilder();
                sb.append(split[1]).append(".").append(split[2]);
                String s = sb.toString();

                putInMap(reps, s, num);
                putInMap(reps, split[2], num);

            } else if (split.length == 2) {

                putInMap(reps, split[1], num);
            }

        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> elem : reps.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(elem.getValue()).append(" ").append(elem.getKey());
            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] input1 = {"9001 discuss.leetcode.com"};
        System.out.println("Test 1: " + subdomainVisits(input1));

        // Test Case 2
        String[] input2 = {"900 google.com", "50 mail.google.com"};
        System.out.println("Test 2: " + subdomainVisits(input2));

        // Test Case 3
        String[] input3 = {"500 mail.yahoo.com", "100 sports.yahoo.com", "200 yahoo.com"};
        System.out.println("Test 3: " + subdomainVisits(input3));

        // Edge Case 1: Empty input
        String[] input4 = {};
        System.out.println("Test 4: " + subdomainVisits(input4));

        // Edge Case 2: Single-level domain (not expected but still test)
        String[] input5 = {"300 localhost"};
        System.out.println("Test 5: " + subdomainVisits(input5));
    }
}
