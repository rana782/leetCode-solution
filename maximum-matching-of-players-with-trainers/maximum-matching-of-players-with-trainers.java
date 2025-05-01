// LeetCode: Maximum Matching of Players With Trainers (maximum-matching-of-players-with-trainers)
// Submission ID: 1622857754
// Language: java
// Timestamp (UTC): 2025-05-01T14:35:49Z

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
         int i = 0;
         int j = 0;

         int output = 0;

         while(i<players.length && j<trainers.length){

            if(players[i]<=trainers[j]){
                output++;
                i++;
                j++;
            }
            else{
                j++;
            }
         }

         return output;
    }
}