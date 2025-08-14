// LeetCode: Sliding Window Maximum (sliding-window-maximum)
// Submission ID: 1735348259
// Language: java
// Timestamp (UTC): 2025-08-14T19:41:38Z

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer,Integer>map = new TreeMap<>();
        int output[] = new int[n-k+1];
        int idx = 0;

        int i = 0;
         int j = 0;

         while(i<k){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            i++;
         }
         

         while(i<n){
            output[idx++] = map.lastKey();
            //acquire

            
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
            i++;
            

            //release

            map.put(nums[j],map.get(nums[j])-1);
            if(map.get(nums[j]) == 0)map.remove(nums[j]);
            j++;
         }
        output[idx] = map.lastKey();
         return output;

    }
}