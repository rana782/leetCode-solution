// LeetCode: Kids With the Greatest Number of Candies (kids-with-the-greatest-number-of-candies)
// Submission ID: 1604867806
// Language: java
// Timestamp (UTC): 2025-04-12T18:23:22Z

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = Integer.MIN_VALUE;

        for(int ele : candies){
            maxi = Math.max(maxi,ele);
        }

        List<Boolean> output = new ArrayList<>();

        for(int i = 0; i<candies.length; i++){
            if(candies[i]+extraCandies>=maxi)output.add(true);
            else{
                output.add(false);
            }
        }

        return output;
    }
}