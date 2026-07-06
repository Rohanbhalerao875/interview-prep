/**
 * Problem: LongestSubstringWithoutRepeatingCharacters
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for LongestSubstringWithoutRepeatingCharacters
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        if(s.length()==1){
            return 1;
        }
        if(s.length()==0){
            return 0;
        }
        int l =0;
        int r =1;
        int ans = 0;
        char[] word = s.toCharArray();
        hs.add(word[0]);
        while(r<s.length()){
            if(!hs.contains(word[r])){
                hs.add(word[r]);
                r++;
                if(r-l>ans){
                    ans =r-l;
                }
            }else{
                hs.remove(word[l]);
                l++;
            }


        }
return ans;


    }
}
