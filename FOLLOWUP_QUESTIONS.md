# Follow-Up Questions Tracker

Comprehensive checklist of follow-up questions and variations from all LeetCode problems in this repository.
Update this file whenever new solutions are added. Check items off as you complete them.

---

## Arrays

### Two Sum (LeetCode #1)
- [ ] Two Sum II — Input Array is Sorted (use two pointers instead of hash map)
- [ ] Two Sum III — Data Structure Design (add/find with HashSet, handle duplicates)
- [ ] 3Sum (find all unique triplets, use sorting + two pointers, watch for duplicates)
- [ ] 4Sum (extend 3Sum logic with nested loops)
- [ ] Return all pairs instead of first pair (deduplication challenge)
- [ ] Solve with O(1) space using sorting + two pointers (lose original indices)
- [ ] K-Sum generalized solution (recursive approach with base case)
- [ ] Two Sum in BST (use inorder traversal + two pointers)

### Contains Duplicate (LeetCode #217)
- [ ] Contains Duplicate II (index distance k constraint, sliding window)
- [ ] Contains Duplicate III (value distance t + index distance k, TreeSet approach)
- [ ] Duplicate Subtrees (serialize subtree, use HashSet for detection)
- [ ] Find All Duplicates in an Array (in-place marking with negatives)
- [ ] First Unique Character in a String (frequency map + single pass)
- [ ] Longest Substring Without Repeating Characters (sliding window + HashMap)
- [ ] Most Frequent Element (frequency map, priority queue for top K)
- [ ] Remove Duplicates from Sorted Array (two pointers, in-place)
- [ ] Intersection of Two Arrays (HashSet or sorting + two pointers)
- [ ] Union of Two Arrays (combined HashSet)

### Valid Anagram (LeetCode #242)
- [ ] Group Anagrams (HashMap<sorted string, list of words>, see GroupAnagrams.java)
- [ ] Anagram Substring (sliding window + char frequency map)
- [ ] Smallest Anagram difference (rearrange to minimize lexicographic)
- [ ] Check if strings can be made equal by rearranging (extended anagram)
- [ ] Find all anagrams in word list (batch version)

### Group Anagrams (LeetCode #49)
- [ ] Top K Anagrams by Frequency (use PriorityQueue)
- [ ] Anagrams with constraint (max length, specific characters)
- [ ] Serialization of anagrams (unique key generation strategies)

---

## Linked Lists

### Reverse Linked List (LeetCode #206)
- [ ] Reverse Linked List II (reverse only sublist from m to n)
- [ ] Reverse Every K Group (groups of k, handle remainder)
- [ ] Palindrome Linked List (reverse second half, compare)
- [ ] Reverse in pairs (reverse every 2 nodes)
- [ ] Swap Nodes in Pairs (similar to reverse in pairs)

### Merge Two Sorted Lists (LeetCode #21)
- [ ] Merge K Sorted Lists (use min-heap or divide & conquer)
- [ ] Merge Sorted Array (array version with in-place merging from end)

### Linked List Cycle (LeetCode #141)
- [ ] Linked List Cycle II (find cycle start node)
- [ ] Circular Array Detection (treat as cycle problem)

### LRU Cache (LeetCode #146)
- [ ] LFU Cache (least frequently used eviction)
- [ ] Time-based Cache with expiry (TTL logic)

---

## Trees

### Binary Tree Level Order Traversal (LeetCode #102)
- [ ] Vertical Order Traversal of Binary Tree
- [ ] Boundary Traversal (left, bottom, right boundary)
- [ ] Zigzag Level Order Traversal (LeetCode #103)

### Validate Binary Search Tree (LeetCode #98)
- [ ] Recover BST (two nodes swapped, fix it)
- [ ] Serialize & Deserialize BST (compact representation)

### Lowest Common Ancestor (LeetCode #236)
- [ ] LCA in BST (simpler binary search property)
- [ ] LCA without parent pointers (DFS on binary tree)

---

## Graphs

### Number of Islands (LeetCode #200)
- [ ] Max Area of Island (track size, not just count)
- [ ] Number of Distinct Islands (use shape hashing or canonicalization)
- [ ] Surrounded Regions (DFS from boundary to mark safe regions)

### Clone Graph (LeetCode #133)
- [ ] Deep copy structures in general (hashmap for node mapping)

### Course Schedule (LeetCode #207)
- [ ] Course Schedule II (return actual schedule, topological sort with path)
- [ ] Alien Dictionary (topological sort on character graph)

### Topological Sort / Alien Dictionary (LeetCode #269)
- [ ] Kahn's Algorithm (BFS-based topological sort)
- [ ] DFS-based topological sort (post-order processing)

---

## Dynamic Programming

### Climbing Stairs (LeetCode #70)
- [ ] Min Cost Climbing Stairs (with cost array)
- [ ] Jump Game (can you reach last index with limited jumps)
- [ ] Jump Game II (minimum jumps to reach end)

### House Robber (LeetCode #198)
- [ ] House Robber II (circular array, compare rob(0..n-2) vs rob(1..n-1))
- [ ] House Robber III (tree version with parent-child constraint)

### Coin Change (LeetCode #322)
- [ ] Coin Change II (count number of ways, not minimum coins)
- [ ] Coin Change with exact amount (variations)

### Word Break (LeetCode #139)
- [ ] Word Break II (return all possible sentences, backtracking)

### Edit Distance (LeetCode #72)
- [ ] Distinct Subsequences (count, not distance)
- [ ] Shortest Edit Distance with operations weighted
- [ ] One Edit Distance (check if exactly one operation away)

---

## Sorting & Searching

### Binary Search (LeetCode #704)
- [ ] Search in Rotated Sorted Array (LeetCode #33)
- [ ] Find First and Last Position of Element (LeetCode #34)
- [ ] Median of Two Sorted Arrays (LeetCode #4)
- [ ] Kth Largest Element in Array (LeetCode #215)
- [ ] Time-based Key-Value Store (binary search on timestamps)

### Merge K Sorted Lists (LeetCode #23)
- [ ] Merge K Sorted Arrays (generalization)

---

## Misc / Multi-Category

### Permutations (LeetCode #46)
- [ ] Permutations II (with duplicates, avoid duplicates in result)
- [ ] Next Permutation (find lexicographically next, in-place)
- [ ] Permutation Sequence (find kth permutation without generating all)

### N-Queens (LeetCode #51)
- [ ] N-Queens II (count solutions, not boards)
- [ ] Sudoku Solver (similar backtracking, more constraints)

### Matrix Problems (LeetCode #73, #48, #79)
- [ ] Set Matrix Zeroes (in-place marking without extra space)
- [ ] Spiral Matrix (multiple traversal variations)
- [ ] Word Search in Matrix (with backtracking)
- [ ] Rotate Matrix (90, 180, 270 degrees)

---

## Problem-Specific Patterns to Master

### Patterns encountered:
- **HashMap/HashSet**: Two Sum, Anagrams, Duplicates, LRU Cache
- **Sliding Window**: Substring without duplicates, Anagram substring, Repeated DNA
- **Two Pointers**: Sorted arrays, Linked lists, Cycle detection
- **Recursion/Backtracking**: Permutations, N-Queens, Sudoku
- **BFS/DFS**: Graphs, Islands, Trees
- **Dynamic Programming**: Climbing stairs, House robber, Coin change, Word break
- **Topological Sort**: Course schedule, Alien dictionary, Task scheduling
- **Heap/Priority Queue**: Merge K lists, Kth largest, Top K frequent
- **Trie**: Word search, Word list problems
- **Union-Find**: Connected components, Cycle detection, Disjoint sets

---

## Progress Tracking

### Completed (with annotations):
- [x] Two Sum (LeetCode #1)
- [x] Contains Duplicate (LeetCode #217)

### In Progress:
- [ ] Valid Anagram (LeetCode #242)
- [ ] Group Anagrams (LeetCode #49)
- [ ] Top K Frequent Elements (LeetCode #347)
- ... (remaining 75 problems)

### Not Started:
- Linked Lists (8 problems)
- Trees (20 problems)
- Graphs (8 problems)
- Dynamic Programming (15 problems)
- Sorting & Searching (10 problems)
- Misc (12 problems)

---

## How to Use This File

1. **Before solving**: Check this file for follow-up variations on the problem you're tackling.
2. **After solving**: Add any new follow-up questions discovered during implementation.
3. **When stuck**: Refer to the patterns section to understand which technique to apply.
4. **Revision**: Use this checklist to ensure you've covered all key variations before interviews.

---

## Notes for Interview Prep

- **Must-know patterns**: HashMap, sliding window, two pointers, recursion, BFS/DFS, DP
- **Priority order**: Master arrays/strings → linked lists → trees → graphs → DP → advanced patterns
- **Time constraint**: 45 min per problem in real interviews; practice speed + correctness
- **Communication**: Always explain your approach before coding; ask clarifying questions

---

*Last updated: 2026-06-27*
*Total follow-ups tracked: 80+*
