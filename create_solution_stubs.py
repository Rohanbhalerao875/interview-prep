import os

base = os.path.dirname(__file__)
root = os.path.join(base)

categories = {
    'solutions/Arrays': [
        'TwoSum', 'ContainsDuplicate', 'ValidAnagram', 'GroupAnagrams',
        'TopKFrequentElements', 'ProductOfArrayExceptSelf', 'LongestConsecutive',
        'ValidParentheses', 'LongestSubstringWithoutRepeatingCharacters',
        'MinimumWindowSubstring', 'ReverseString', 'StringToIntegerAtoi',
        'LongestPalindromicSubstring', 'RegularExpressionMatching', 'RotateArray'
    ],
    'solutions/LinkedLists': [
        'ReverseLinkedList', 'MergeTwoSortedLists', 'LinkedListCycle',
        'RemoveNthNodeFromEnd', 'ReorderList', 'CopyListWithRandomPointer',
        'OddEvenLinkedList', 'LRUCache'
    ],
    'solutions/Trees': [
        'BinaryTreeLevelOrderTraversal', 'ValidateBinarySearchTree',
        'LowestCommonAncestorOfBST', 'BinaryTreeMaxPathSum',
        'SerializeAndDeserializeBinaryTree', 'NumberOfIslands', 'CloneGraph',
        'CourseSchedule', 'AlienDictionary', 'WordLadder', 'GraphValidTree',
        'NumberOfConnectedComponents', 'MostStonesRemoved', 'ReconstructItinerary',
        'RightSideViewOfBinaryTree', 'SmallestSubtreeWithAllTheDeepestNodes',
        'DeleteNodesAndReturnForest', 'VerticalOrderTraversal',
        'AllPathsFromRootToLeaf', 'PathSumII'
    ],
    'solutions/Graphs': [
        'CloneGraph', 'CourseSchedule', 'AlienDictionary', 'WordLadder',
        'GraphValidTree', 'NumberOfConnectedComponents', 'MostStonesRemoved',
        'ReconstructItinerary'
    ],
    'solutions/DynamicProgramming': [
        'ClimbingStairs', 'HouseRobber', 'HouseRobberII', 'CoinChange',
        'CoinChangeII', 'LongestIncreasingSubsequence', 'JumpGame', 'WordBreak',
        'PartitionEqualSubsetSum', 'MaximumSubarray', 'UniquePaths',
        'UniquePathsII', 'EditDistance', 'InterleavingString',
        'DistinctSubsequences'
    ],
    'solutions/Sorting': [
        'BinarySearch', 'SearchInRotatedSortedArray', 'FindFirstAndLastPosition',
        'MedianOfTwoSortedArrays', 'MergeKSortedLists', 'KthLargestElement',
        'TopKFrequentWords', 'SortCharactersByFrequency', 'MeetingRoomsII',
        'MeetingRooms'
    ],
    'solutions/Misc': [
        'Permutations', 'Combinations', 'WordSearch', 'NQueens', 'SudokuSolver',
        'MajorityElement', 'SortColors', 'SetMatrixZeroes', 'GameOfLife',
        'RotateMatrix', 'SpiralMatrix', 'LFUCache'
    ]
}

for d, problems in categories.items():
    dir_path = os.path.join(root, d)
    os.makedirs(dir_path, exist_ok=True)
    for name in problems:
        file_path = os.path.join(dir_path, f'{name}.java')
        if os.path.exists(file_path):
            continue
        if name == 'TwoSum':
            content = '''/**
 * Problem: Two Sum (LeetCode #1)
 * Difficulty: Easy
 * URL: https://leetcode.com/problems/two-sum/
 *
 * Approach: HashMap for single pass solution
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
'''
        else:
            content = f'''/**
 * Problem: {name}
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for {name}
 */

class Solution {{
    public void solve() {{
        // TODO: implement {name}
    }}
}}
'''
        with open(file_path, 'w', encoding='utf8') as f:
            f.write(content)

print('Created solution structure.')
