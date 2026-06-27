/**
 * Problem: Valid Anagram (LeetCode #242)
 * Difficulty: Easy
 * URL: https://leetcode.com/problems/valid-anagram/
 *
 * The logic below is preserved from your own approach.
 * I only cleaned the formatting and added short comments for revision.
 */

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // First, if the lengths differ, they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency-array approach: count characters from both strings.
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char b = t.charAt(i);
            freq1[c - 'a']++;
            freq2[b - 'a']++;
        }

        for (int j = 0; j < 26; j++) {
            if (freq1[j] != freq2[j]) {
                return false;
            }
        }
        return true;
    }
}

// Your earlier sorting-based idea is preserved here as a separate helper.
// This is not used in the main Solution method, but it is useful for review.
class SolutionSort {
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }
}