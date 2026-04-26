package Greedy;

/*
 * Problem: Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Source: LeetCode #121 (NeetCode 150 - Sliding Window / Greedy)
 *
 * You are given an array prices where prices[i] is the price of a given stock on day i.
 * Maximize your profit by choosing a single day to buy one stock and a different day in
 * the future to sell it. Return the maximum profit, or 0 if no profit is possible.
 *
 * Approach (greedy / single pass):
 * Track the minimum price seen so far while iterating from left to right. For each day,
 * the best profit ending on that day is price[i] - minSoFar. Keep the maximum of those
 * day-wise profits as the answer. Since we never look back, this runs in one pass.
 *
 * Time Complexity:  O(n) - single scan.
 * Space Complexity: O(1) - two scalar variables (minPrice, maxProfit).
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] t1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: [7,1,5,3,6,4]   -> Max profit: " + maxProfit(t1)); // 5

        int[] t2 = {7, 6, 4, 3, 1};
        System.out.println("Input: [7,6,4,3,1]     -> Max profit: " + maxProfit(t2)); // 0

        int[] t3 = {2, 4, 1};
        System.out.println("Input: [2,4,1]         -> Max profit: " + maxProfit(t3)); // 2

        int[] t4 = {3, 2, 6, 5, 0, 3};
        System.out.println("Input: [3,2,6,5,0,3]   -> Max profit: " + maxProfit(t4)); // 4
    }
}
