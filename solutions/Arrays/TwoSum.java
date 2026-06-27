/**
 * Problem: Two Sum (LeetCode #1)
 * Difficulty: Easy
 * URL: https://leetcode.com/problems/two-sum/
 *
 * Summary:
 * Given an array of integers `nums` and an integer `target`, return indices
 * of the two numbers such that they add up to `target`.
 *
 * Key constraints:
 * - Exactly one valid answer exists (typical LeetCode variant).
 * - You may not use the same element twice.
 *
 * Best approach for interviews:
 * - One-pass HashMap: O(n) time, O(n) extra space.
 * - Two-pass HashMap is also valid but slightly less optimal in practice.
 * - Sorting + two pointers can reduce thinking about values but loses original
 *   indices (so it's not suitable unless you track indices separately).
 *
 * Common pitfalls and hints:
 * - Remember to store value -> index in the map, not index -> value.
 * - Handle duplicates carefully: map should store the last (or first) index,
 *   but a one-pass algorithm avoids ambiguity by checking for complement first.
 * - Don't assume input is sorted.
 * - Think about integer overflow only if constraints are extreme (usually not here).
 *
 * Follow-ups to practice:
 * - Return all unique pairs that sum to target.
 * - Solve with O(1) extra space when allowed to modify array (sort in-place,
 *   but track original indices before sorting).
 * - What if there were no guarantee of exactly one solution? How to return
 *   all pairs without duplicates?
 */

import java.util.HashMap;
import java.util.Map;

// Optimal: One-pass HashMap. Clean and interview-ready implementation.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map from value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // If complement seen earlier, we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current value with index for future complements
            map.put(nums[i], i);
        }

        // According to problem, there will always be one solution;
        // returning empty array as fallback (not expected in typical tests)
        return new int[] {};
    }
}

// Alternative: Brute-force O(n^2) solution. Useful for very small arrays
// or as a correctness baseline when writing tests.
class SolutionBruteForce {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

// Two-pass HashMap: first store all elements, then search for complements.
// Slightly easier to reason but requires two iterations.
class SolutionTwoPass {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[] {};
    }
}

/*
 * Interview hints (short):
 * - Explain approach: O(n) using HashMap, store value->index, check complement.
 * - Mention edge cases: duplicates, negative numbers, single-element arrays.
 * - If asked to optimize space: discuss sorting + two pointers and its tradeoffs.
 * - If asked to return all pairs: use frequency map + careful deduplication.
 *
 * Recommended practice tasks:
 * 1) Re-implement Two Sum returning values instead of indices.
 * 2) Write unit tests for cases: [3,3], target=6; negatives; no solution.
 * 3) Implement variant that returns all unique index pairs.
 */