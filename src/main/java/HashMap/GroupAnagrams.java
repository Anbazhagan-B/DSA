package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem: Group Anagrams
 * Difficulty: Medium
 * Source: LeetCode #49 / NeetCode 150 / LC Top Interview 150
 *
 * Given an array of strings strs, group the anagrams together. An anagram is
 * a word formed by rearranging the letters of another. Return the groups in
 * any order. Strings consist of lowercase English letters and may be empty.
 *
 * Approach (HashMap by character-count signature):
 *   For each string, build a 26-length count array of its letter
 *   frequencies and convert that into a string key (e.g. "1#0#2#..."). All
 *   anagrams collapse to the same key, so we bucket them together in a map
 *   keyed by signature. The map's values are the answer.
 *
 * Time Complexity:  O(n * k) — n strings, each scanned once over k chars.
 * Space Complexity: O(n * k) — storing the grouped strings and signatures.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> buckets = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int c : count) {
                key.append(c).append('#');
            }
            buckets.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(buckets.values());
    }

    public static void main(String[] args) {
        String[] in1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input:  " + Arrays.toString(in1));
        System.out.println("Output: " + groupAnagrams(in1));
        // [[eat, tea, ate], [tan, nat], [bat]]

        String[] in2 = {""};
        System.out.println("Input:  " + Arrays.toString(in2));
        System.out.println("Output: " + groupAnagrams(in2)); // [[""]]

        String[] in3 = {"a"};
        System.out.println("Input:  " + Arrays.toString(in3));
        System.out.println("Output: " + groupAnagrams(in3)); // [[a]]
    }
}
