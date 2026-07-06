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

        if(word[0]=='}' || word[0]== ']'||word[0]==')'){
            return false;
        }

        for(int i=0;i<s.length();i++){
           if(word[i]=='{'){
            st.push('}');
           } 
          else if(word[i]=='['){
            st.push(']');
          }
            else if(word[i]=='('){
            st.push(')');
           }
           
           
            else{
                if(st.size()==0){
                    return false;
                }
                else if(st.peek()!=word[i]){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        
        if(st.size()==0){
            return true;
        }else{return false;}



    }
}
