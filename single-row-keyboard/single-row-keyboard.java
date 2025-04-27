// LeetCode: Single-Row Keyboard (single-row-keyboard)
// Submission ID: 1619355668
// Language: java
// Timestamp (UTC): 2025-04-27T13:31:14Z

class Solution {
    public int calculateTime(String keyboard, String word) {
        int prevIdx = 0;
        HashMap<Character,Integer>map = new HashMap<>();

        for(int i = 0; i<keyboard.length(); i++){
            char ch = keyboard.charAt(i);
            map.put(ch,i);
        }

        int cost = 0;

        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);

            int idx = map.get(ch);
            cost+=Math.abs(prevIdx-idx);

            prevIdx = idx;
        }

        return cost;
    }
}