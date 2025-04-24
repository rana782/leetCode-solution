// LeetCode: Minimum Consecutive Cards to Pick Up (minimum-consecutive-cards-to-pick-up)
// Submission ID: 1616567412
// Language: java
// Timestamp (UTC): 2025-04-24T11:03:32Z

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int output = Integer.MAX_VALUE;

        int j = 0;

        for(int i = 0; i<cards.length; i++){

            while(j<=i && map.containsKey(cards[i])){
                int len = i-j+1;
                output = Math.min(output,len);

                map.put(cards[j],map.get(cards[j])-1);
                if(map.get(cards[j]) == 0)map.remove(cards[j]);

                j++;
            }

            map.put(cards[i],map.getOrDefault(cards[i],0)+1);
        }

        return output == Integer.MAX_VALUE ? -1 : output;
    }
}