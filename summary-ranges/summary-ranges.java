// LeetCode: Summary Ranges (summary-ranges)
// Submission ID: 1639286819
// Language: java
// Timestamp (UTC): 2025-05-20T12:39:52Z

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>output = new ArrayList<>();
        int i = 0;

        while(i<nums.length){
            int j = i;

            while(j+1<nums.length && nums[j]+1 == nums[j+1]){
                j++;
            }

            if(nums[i] == nums[j]){
                output.add(nums[i]+"");
            }
            else{
                output.add(nums[i]+"->"+nums[j]);
            }
            i = j+1;
        }

        return output;
    }
}