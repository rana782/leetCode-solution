// LeetCode: Set Mismatch (set-mismatch)
// Submission ID: 1520807195
// Language: java
// Timestamp (UTC): 2025-01-26T06:20:52Z

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int totalSum = (n*(n+1))/2;

      

          int dupliCate = 0;
          int actualSum = 0;
      HashSet<Integer> set = new HashSet<>();

      for(int i = 0; i<n; i++){
        if(set.contains(nums[i])){
            actualSum+=nums[i];
            dupliCate = nums[i];
        }
        else{
            set.add(nums[i]);
            actualSum+=nums[i];
        }
      }


        int missing = totalSum-(actualSum-dupliCate);

        int output[] = {dupliCate,missing};
        return output;
    }
}