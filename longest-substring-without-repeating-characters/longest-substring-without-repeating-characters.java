// LeetCode: Longest Substring Without Repeating Characters (longest-substring-without-repeating-characters)
// Submission ID: 1735259082
// Language: java
// Timestamp (UTC): 2025-08-14T18:07:05Z

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        int maxLength = 0;
        int i =0 ;
         int j = 0;


         while(i<s.length()){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(j<=i && map.size()<i-j+1){
                ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0)map.remove(ch);

                j++;
            }

            int curr_length = i-j+1;
            maxLength = Math.max(maxLength,curr_length);
            i++;
         }

         return maxLength;

    }
}