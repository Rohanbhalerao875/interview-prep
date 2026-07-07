/**
 * Problem: MinimumWindowSubstring
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for MinimumWindowSubstring
 */

class Solution {
    public String minWindow(String s, String t) {
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int n = s.length();
        int count =0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        char [] c = t.toCharArray();
        char [] cs = s.toCharArray();
        for(int i=0;i<t.length();i++){
            if(hm.containsKey(c[i])){
                hm.put(c[i],hm.get(c[i])+1);
            }
            else{
                hm.put(c[i],1);
            }

        }


        while(r<n){
            //while  we need to move the right standing on a valid L
            while(r < n && count != t.length()){
               if(hm.containsKey(cs[r])){
                    if(hm.get(cs[r])>0){
                        count++;
                    }
                    hm.put(cs[r],hm.get(cs[r])-1);
                    r++;
               }else{
                hm.put(cs[r],-1);
                r++;
               }
            }
           if(count != t.length()){
    break;
}
            while(l<r && count == t.length() ){
                if(r-l<minlen){
                    minlen=r-l;
                    start = l;
                }
                
                hm.put(cs[l],hm.get(cs[l])+1);
                if(hm.get(cs[l])>0){
                    count--;
                }
                l++;
            }
        }
          if(minlen == Integer.MAX_VALUE)
    return "";
            String ans = s.substring(start, start + minlen);
        return ans;

    }
}
