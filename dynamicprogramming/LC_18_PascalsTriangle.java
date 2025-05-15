package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LC_18_PascalsTriangle {

    /**
     * TC: O(N^2) where N is the number of rows
     * SC: O(1) 
     * (O(N^2) for storing the triangle, but output is not counted in space complexity)
     * 
     * The function generates Pascal's Triangle up to numRows.
     * Each row is built based on the previous row.
     */


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1); // First row

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            currRow.add(1); // First element is always 1

            for (int col = 1; col < prevRow.size(); col++) {
                currRow.add(prevRow.get(col - 1) + prevRow.get(col));
            }

            currRow.add(1); // Last element is also 1
            triangle.add(currRow);
        }

        return triangle;
    }

    public static void main(String[] args) {

        System.out.println("Test 1 (numRows = 1): " + generate(1));
        System.out.println("Test 2 (numRows = 2): " + generate(2));
        System.out.println("Test 3 (numRows = 5): " + generate(5));
        System.out.println("Edge Test (numRows = 0): " + generate(0));
    }
}
