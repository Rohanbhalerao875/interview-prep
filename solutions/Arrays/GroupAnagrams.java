/**
 * Problem: Group Anagrams (LeetCode #49)
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/group-anagrams/
 *
 * This solution groups strings by their sorted character signature.
 * The original logic is preserved and only formatting/comments were added.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            if (!groups.containsKey(signature)) {
                groups.put(signature, new ArrayList<>());
            }
            groups.get(signature).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}

/*
 * Interview hint:
 * - Use the sorted string as the key for grouping anagrams.
 * - Time complexity: O(n * k log k), where k is average word length.
 * - Space complexity: O(n * k) for building keys and groups.
 *
 * Follow-up suggestion:
 * - Solve a version that uses character count signature instead of sorting.
 */