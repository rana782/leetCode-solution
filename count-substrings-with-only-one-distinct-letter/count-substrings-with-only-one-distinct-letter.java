// LeetCode: Count Substrings with Only One Distinct Letter (count-substrings-with-only-one-distinct-letter)
// Submission ID: 1613453111
// Language: java
// Timestamp (UTC): 2025-04-21T11:09:36Z

class Solution {
    public int countLetters(String s) {
        HashMap<Character,Integer>map = new HashMap<>();

        int output = 0;
        int j = 0;

        for(int i = 0; i<s.length(); i++){
                    char ch = s.charAt(i);
                    map.put(ch,map.getOrDefault(ch,0)+1);

                    while(j<=i && map.size()!=1){
                        ch = s.charAt(j);
                        map.put(ch,map.get(ch)-1);

                        if(map.get(ch) == 0)map.remove(ch);
                        j++;
                    }

                    int len = i-j+1;
                    output+=len;
        }

        return output;
    }
}