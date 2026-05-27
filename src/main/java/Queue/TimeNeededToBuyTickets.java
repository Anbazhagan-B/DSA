/**
 * Problem: Time Needed to Buy Tickets
 * Difficulty: Easy
 * Source: LeetCode #2073 / LeetCode 75
 *
 * Problem Statement:
 * There are n people in a line to buy tickets, where person i wants to buy tickets[i] tickets.
 * People buy tickets in a circular manner -- everyone in front of a person must have purchased
 * one ticket before they can buy one more. A person who has finished buying all their tickets
 * leaves the queue. Return the time taken for person k to finish buying all their tickets,
 * where each ticket purchase takes 1 second.
 *
 * Approach:
 * For each person, determine how many rounds they will actually buy:
 * - People at index <= k buy min(tickets[i], tickets[k]) tickets.
 * - People at index > k buy min(tickets[i], tickets[k]-1) tickets.
 * Sum all these values to get the total time elapsed.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int target = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target - 1);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TimeNeededToBuyTickets solution = new TimeNeededToBuyTickets();

        // Example 1: tickets=[2,3,2], k=2 -> Expected: 6
        System.out.println(solution.timeRequiredToBuy(new int[]{2, 3, 2}, 2)); // 6

        // Example 2: tickets=[5,1,1,1], k=0 -> Expected: 8
        System.out.println(solution.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0)); // 8

        // Example 3: tickets=[1,2,3], k=1 -> Expected: 4
        System.out.println(solution.timeRequiredToBuy(new int[]{1, 2, 3}, 1)); // 4

        // Example 4: tickets=[3,3,3], k=1 -> Expected: 8
        System.out.println(solution.timeRequiredToBuy(new int[]{3, 3, 3}, 1)); // 8
    }
}
