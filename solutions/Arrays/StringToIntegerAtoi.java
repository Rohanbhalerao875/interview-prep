/**
 * Problem: StringToIntegerAtoi
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for StringToIntegerAtoi
 */

class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i=0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }        
        if (i >= n) return 0;
        int result = 0;
        int sign = 1;
       
        if(i<n){
             char ch = s.charAt(i);
            if(ch=='-'){
                sign=sign*-1;
                i++;
            }
            else if(ch=='+'){
                i++;
            }
        }
        int MaxValue = Integer.MAX_VALUE;
        int maxDiv10 = MaxValue / 10;
        int maxLast = MaxValue % 10;
        while(i<n){
            char ch = s.charAt(i);
            
            
            if(ch<'0' || ch>'9'){
                break;
            }
            
            int digit = s.charAt(i)-'0';

            if (result > maxDiv10 || (result == maxDiv10 && digit > maxLast)){   // (result > maxDiv10 || (result == maxDiv10 && digit > maxLastDigit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result*10 + digit;
            i++;
    }
                return sign*result;
}
}
