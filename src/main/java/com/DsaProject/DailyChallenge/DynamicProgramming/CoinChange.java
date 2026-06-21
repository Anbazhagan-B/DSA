package com.DsaProject.DailyChallenge.DynamicProgramming;

/*
 * Problem: Coin Change
 *
 * You are given an integer array `coins` representing coins of different
 * denominations and an integer `amount` representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins,
 * return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Constraints:
 *   - 1 <= coins.length <= 12
 *   - 1 <= coins[i] <= 2^31 - 1
 *   - 0 <= amount <= 10^4
 *
 * Examples:
 *   Input:  coins = [1, 2, 5], amount = 11   -> Output: 3
 *     Explanation: 11 = 5 + 5 + 1 (three coins is the minimum).
 *
 *   Input:  coins = [2], amount = 3          -> Output: -1
 *     Explanation: 3 cannot be formed using only coins of value 2.
 *
 *   Input:  coins = [1], amount = 0          -> Output: 0
 *     Explanation: No coins are needed to make amount 0.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // TODO: implement
        return -1;
    }
}
