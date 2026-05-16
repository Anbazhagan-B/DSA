/*
 * Problem: Coin Change
 * Difficulty: Medium
 * Source: LeetCode #322, NeetCode 150
 *
 * Problem Statement:
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money. Return the fewest number
 * of coins that you need to make up that amount. If that amount of money cannot be made
 * up by any combination of the coins, return -1. You may assume that you have an
 * infinite number of each kind of coin.
 *
 * Approach:
 * Use bottom-up dynamic programming. Create a dp[] array of size amount+1,
 * initialized to amount+1 (acts as infinity). dp[0] = 0. For each amount from 1
 * to amount, try each coin and update dp[i] = min(dp[i], dp[i - coin] + 1).
 * At the end, dp[amount] holds the minimum coins, or -1 if unreachable.
 *
 * Time Complexity: O(amount * n) where n = number of coins
 * Space Complexity: O(amount)
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();

        // Example 1: coins=[1,5,11], amount=11 => 1 coin (use 11 itself)
        System.out.println(sol.coinChange(new int[]{1, 5, 11}, 11)); // Output: 1

        // Example 2: coins=[1,2,5], amount=11 => 3 coins (5+5+1)
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11));  // Output: 3

        // Example 3: coins=[2], amount=3 => -1 (not possible)
        System.out.println(sol.coinChange(new int[]{2}, 3));          // Output: -1

        // Example 4: coins=[1], amount=0 => 0 coins
        System.out.println(sol.coinChange(new int[]{1}, 0));          // Output: 0
    }
}
