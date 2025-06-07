// LeetCode: Longest Substring with At Most K Distinct Characters (longest-substring-with-at-most-k-distinct-characters)
// Submission ID: 1656885187
// Language: java
// Timestamp (UTC): 2025-06-07T17:47:25Z

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer>map = new HashMap<>();
        int output = 0;
        
        int i = 0;
         int j = 0;
        
        while(i<s.length()){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(j<=i && map.size()>k){
                char ch1 = s.charAt(j);
                map.put(ch1,map.get(ch1)-1);
                if(map.get(ch1) == 0)map.remove(ch1);
                j++;
            }
            
            int currLength = i-j+1;
            output = Math.max(currLength,output);
            i++;
        }
        
        return output;
    }
}