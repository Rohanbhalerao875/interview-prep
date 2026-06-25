$base = Get-Location
$categories = @{
    'solutions\Arrays' = @(
        'TwoSum','ContainsDuplicate','ValidAnagram','GroupAnagrams','TopKFrequentElements','ProductOfArrayExceptSelf','LongestConsecutive','ValidParentheses','LongestSubstringWithoutRepeatingCharacters','MinimumWindowSubstring','ReverseString','StringToIntegerAtoi','LongestPalindromicSubstring','RegularExpressionMatching','RotateArray'
    )
    'solutions\LinkedLists' = @(
        'ReverseLinkedList','MergeTwoSortedLists','LinkedListCycle','RemoveNthNodeFromEnd','ReorderList','CopyListWithRandomPointer','OddEvenLinkedList','LRUCache'
    )
    'solutions\Trees' = @(
        'BinaryTreeLevelOrderTraversal','ValidateBinarySearchTree','LowestCommonAncestorOfBST','BinaryTreeMaxPathSum','SerializeAndDeserializeBinaryTree','NumberOfIslands','CloneGraph','CourseSchedule','AlienDictionary','WordLadder','GraphValidTree','NumberOfConnectedComponents','MostStonesRemoved','ReconstructItinerary','RightSideViewOfBinaryTree','SmallestSubtreeWithAllTheDeepestNodes','DeleteNodesAndReturnForest','VerticalOrderTraversal','AllPathsFromRootToLeaf','PathSumII'
    )
    'solutions\Graphs' = @(
        'CloneGraph','CourseSchedule','AlienDictionary','WordLadder','GraphValidTree','NumberOfConnectedComponents','MostStonesRemoved','ReconstructItinerary'
    )
    'solutions\DynamicProgramming' = @(
        'ClimbingStairs','HouseRobber','HouseRobberII','CoinChange','CoinChangeII','LongestIncreasingSubsequence','JumpGame','WordBreak','PartitionEqualSubsetSum','MaximumSubarray','UniquePaths','UniquePathsII','EditDistance','InterleavingString','DistinctSubsequences'
    )
    'solutions\Sorting' = @(
        'BinarySearch','SearchInRotatedSortedArray','FindFirstAndLastPosition','MedianOfTwoSortedArrays','MergeKSortedLists','KthLargestElement','TopKFrequentWords','SortCharactersByFrequency','MeetingRoomsII','MeetingRooms'
    )
    'solutions\Misc' = @(
        'Permutations','Combinations','WordSearch','NQueens','SudokuSolver','MajorityElement','SortColors','SetMatrixZeroes','GameOfLife','RotateMatrix','SpiralMatrix','LFUCache'
    )
}

foreach ($dir in $categories.Keys) {
    $fullDir = Join-Path $base $dir
    New-Item -ItemType Directory -Force -Path $fullDir | Out-Null
    foreach ($name in $categories[$dir]) {
        $filePath = Join-Path $fullDir "$name.java"
        if (Test-Path $filePath) { continue }
        if ($name -eq 'TwoSum') {
            $content = @'
/**
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
'@
        } else {
            $content = @"
/**
 * Problem: $name
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for $name
 */

class Solution {
    public void solve() {
        // TODO: implement $name
    }
}
"@
        }
        Set-Content -Path $filePath -Value $content -Encoding UTF8
    }
}
Write-Output 'Created solution stub structure.'
