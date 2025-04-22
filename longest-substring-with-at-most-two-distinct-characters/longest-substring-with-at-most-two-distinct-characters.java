// LeetCode: Longest Substring with At Most Two Distinct Characters (longest-substring-with-at-most-two-distinct-characters)
// Submission ID: 1615010597
// Language: java
// Timestamp (UTC): 2025-04-22T20:36:21Z

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer>map = new HashMap<>();

        int output = 0;

        int i = 0;
         int j = 0;

         while(i<s.length()){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()>2){
                ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);

                if(map.get(ch) == 0)map.remove(ch);

                j++;
            }

            int len = i-j+1;
            output = Math.max(output,len);
            i++;
         }

         return output;
    }
}