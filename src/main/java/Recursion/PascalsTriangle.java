/**
 * Problem: Pascal's Triangle
 * Difficulty: Easy
 * Source: LeetCode #118 / LeetCode Top Interview 150
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * The first and last element of every row is always 1.
 *
 * Approach:
 * Use recursion to build each row from the previous row. Base case: empty result for 0 rows.
 * Recursively build up to (row - 1), then construct the current row by starting and ending
 * with 1 and filling each middle element as prevRow[j-1] + prevRow[j].
 *
 * Time Complexity: O(numRows^2) - total elements in Pascal's triangle
 * Space Complexity: O(numRows^2) - storing all rows in result
 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        buildRows(result, numRows);
        return result;
    }

    private static void buildRows(List<List<Integer>> result, int row) {
        if (row == 0) return;
        buildRows(result, row - 1);

        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        if (!result.isEmpty()) {
            List<Integer> prevRow = result.get(result.size() - 1);
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currentRow.add(1);
        }
        result.add(currentRow);
    }

    public static void main(String[] args) {
        // numRows = 5 => [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println("numRows=5: " + generate(5));

        // numRows = 1 => [[1]]
        System.out.println("numRows=1: " + generate(1));

        // numRows = 3 => [[1],[1,1],[1,2,1]]
        System.out.println("numRows=3: " + generate(3));

        // numRows = 6 => [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1]]
        System.out.println("numRows=6: " + generate(6));
    }
}
