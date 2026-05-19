/**
 * Problem: Isomorphic Strings
 * Difficulty: Easy
 * Source: LeetCode #205 / LeetCode 75
 *
 * Given two strings s and t, determine if they are isomorphic. Two strings
 * are isomorphic if the characters in s can be replaced to get t such that
 * all occurrences of a character are replaced with the same character, no
 * two characters map to the same character, and order is preserved.
 *
 * Approach:
 * - Use two HashMaps: one mapping s->t characters, one mapping t->s characters.
 * - For each character pair (cs, ct), verify both maps are consistent.
 * - If any conflict is found (a character maps to two different targets), return false.
 *
 * Time Complexity:  O(n) - single pass through both strings
 * Space Complexity: O(1) - at most 256 ASCII characters in maps
 */
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (sToT.containsKey(cs) && sToT.get(cs) != ct) return false;
            if (tToS.containsKey(ct) && tToS.get(ct) != cs) return false;

            sToT.put(cs, ct);
            tToS.put(ct, cs);
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings sol = new IsomorphicStrings();

        // "egg" -> "add": e->a, g->d
        System.out.println(sol.isIsomorphic("egg", "add"));     // true

        // "foo" -> "bar": f->b, o->a but o already maps to a, then o->r conflict
        System.out.println(sol.isIsomorphic("foo", "bar"));     // false

        // "paper" -> "title": p->t, a->i, p->t, e->l, r->e
        System.out.println(sol.isIsomorphic("paper", "title")); // true

        // "badc" -> "baba": b->b, a->a, d->b (conflict b already maps to b from position 0)
        System.out.println(sol.isIsomorphic("badc", "baba"));   // false
    }
}
