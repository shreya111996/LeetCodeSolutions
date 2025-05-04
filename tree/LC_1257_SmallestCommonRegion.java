package tree;

import java.util.*;

public class LC_1257_SmallestCommonRegion {

    /*
     * TC: O(n * m) - where n is the number of regions and m is the average number of
     * regions in each list
     * SC: O(n * m + n) - where n is the number of regions and m is the average number
     * of regions in each list [+n for the anscestors set]
     */

    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        Map<String, String> childToParent = new HashMap<>();

        for (List<String> region : regions) {
            String parent = region.get(0);
            for (int i = 1; i < region.size(); i++) {
                childToParent.put(region.get(i), parent);
            }
        }

        Set<String> ancestors = new HashSet<>();

        while (region1 != null) {
            ancestors.add(region1);
            region1 = childToParent.get(region1); // move to its parent
        }

        while (!ancestors.contains(region2)) { // until region2 is not found in ancestors set
            region2 = childToParent.get(region2);
        }

        return region2;
    }

    public static void main(String[] args) {
        List<List<String>> regions1 = Arrays.asList(
                Arrays.asList("Earth", "North America", "South America"),
                Arrays.asList("North America", "United States", "Canada"),
                Arrays.asList("United States", "New York", "Boston"),
                Arrays.asList("Canada", "Ontario", "Quebec"),
                Arrays.asList("South America", "Brazil"));
        System.out.println(findSmallestRegion(regions1, "Quebec", "New York")); // Output: "North America"

        List<List<String>> regions2 = Arrays.asList(
                Arrays.asList("Earth", "Asia", "Europe"),
                Arrays.asList("Asia", "China", "India"),
                Arrays.asList("China", "Beijing", "Shanghai"),
                Arrays.asList("India", "Delhi", "Mumbai"),
                Arrays.asList("Europe", "Germany", "France"));
        System.out.println(findSmallestRegion(regions2, "Beijing", "Mumbai")); // Output: "Asia"

        // Edge case: Same region
        System.out.println(findSmallestRegion(regions2, "India", "India")); // Output: "India"

        // Edge case: Region is direct parent of the other
        System.out.println(findSmallestRegion(regions2, "India", "Delhi")); // Output: "India"
    }
}
