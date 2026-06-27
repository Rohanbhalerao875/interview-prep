/**
 * Problem: Contains Duplicate (LeetCode #217)
 * Difficulty: Easy
 * URL: https://leetcode.com/problems/contains-duplicate/
 *
 * Summary:
 * Given an integer array `nums`, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 *
 * Approaches ranked by efficiency:
 * 1. HashSet (Optimal): O(n) time, O(n) space — Best for interviews.
 * 2. Sorting + adjacent check: O(n log n) time, O(1) space if in-place sort allowed.
 * 3. Sorting + two pointers: O(n log n) time, same as above.
 * 4. Brute force (nested loop): O(n^2) time, O(1) space — Avoid unless extremely limited memory.
 *
 * Key insights:
 * - HashSet has O(1) average-case lookup and insert, making it ideal for this problem.
 * - If space is a constraint and array can be modified, sorting is better.
 * - If array is very large but value range is small, consider frequency map or bit array.
 * - For streaming/online scenarios where you process one element at a time, HashSet is required.
 *
 * Edge cases to consider:
 * - Empty array → return false
 * - Single element → return false
 * - All duplicates → return true (early exit on first duplicate)
 * - Large arrays with many duplicates → HashSet can exit early
 * - Negative numbers and zero → no special handling needed
 * - Integer.MIN_VALUE / Integer.MAX_VALUE → no overflow issues
 *
 * Interview tips:
 * - Start with brute force, then optimize to HashSet.
 * - Explain space-time tradeoff: HashSet uses extra space but is faster.
 * - Mention sorting approach as alternative if interviewer asks about space optimization.
 * - Be ready to discuss streaming variant (online algorithm).
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

// Optimal: HashSet (one-pass, O(n) time). Best for most interviews.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            // If already in set, duplicate found
            if (seen.contains(num)) {
                return true;
            }
            // Add to set for future comparisons
            seen.add(num);
        }
        return false;
    }
}

// Alternative: Sorting + adjacent check (O(n log n) time, O(1) space if in-place).
// Useful when space is critical and sorting is allowed.
class SolutionSorting {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

// Brute force: nested loops (O(n^2) time, O(1) space).
// Only suitable for very small arrays or learning purposes.
class SolutionBruteForce {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
 * =============================================================================
 * FOLLOW-UP QUESTIONS & VARIATIONS (Solve these after completing DSA prep)
 * =============================================================================
 *
 * [ ] 1. Contains Duplicate II
 *     - Given k, return true if any value appears at least twice within
 *       index distance k.
 *     - Hint: Use a sliding window with HashSet of size k.
 *
 * [ ] 2. Contains Duplicate III
 *     - Given k and t, return true if there are two distinct indices i, j
 *       such that |nums[i] - nums[j]| <= t and |i - j| <= k.
 *     - Hint: Consider TreeSet or bucket-based approach for range queries.
 *
 * [ ] 3. Duplicate Subtrees
 *     - Find all duplicate subtrees in a binary tree.
 *     - Hint: Serialize subtree to string, use HashSet to detect duplicates.
 *
 * [ ] 4. Find All Duplicates in an Array
 *     - Return all elements that appear twice (modify in-place).
 *     - Hint: Use array indices as hash map (mark visited with negative sign).
 *
 * [ ] 5. Duplicate Emails (SQL variant)
 *     - Find all emails appearing more than once in database.
 *     - Hint: Use GROUP BY and HAVING COUNT(*) > 1.
 *
 * [ ] 6. First Unique Character in a String
 *     - Find first non-repeating character using frequency map.
 *     - Hint: One pass for counts, one pass for first unique.
 *
 * [ ] 7. Longest Substring Without Repeating Characters
 *     - Find length of longest substring without duplicate characters.
 *     - Hint: Sliding window + HashSet/HashMap for character positions.
 *
 * [ ] 8. Most Frequent Element (variations)
 *     - Find element with highest frequency using frequency map.
 *     - Hint: Use HashMap<Value, Count> or PriorityQueue.
 *
 * [ ] 9. Remove Duplicates from Sorted Array
 *     - Modify array in-place to remove duplicates.
 *     - Hint: Two pointers (fast & slow).
 *
 * [ ] 10. Intersection of Two Arrays (with/without duplicates)
 *      - Find common elements between two arrays.
 *      - Hint: HashSet for one array, check containment in second.
 *
 * =============================================================================
 */