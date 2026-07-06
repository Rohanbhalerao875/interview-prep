/**
 * Problem: ValidParentheses
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for ValidParentheses
 */

class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack <>();
        char [] word = s.toCharArray();
        if(s.length()==0 || s.length()==1){
            return false;
        }

        for(int i=0;i<s.length();i++){
           if(word[i]=='{'){
            st.push('}');
           } 
          if(word[i]=='['){
            st.push(']');
          }
           if(word[i]=='('){
            st.push(')');
           }
           if(st.size()!=0 && st.peek()==word[i]){
                st.pop();
           }
               
        }
        
        if(st.size()==0){
            return true;
        }else{return false;}



    }
}
