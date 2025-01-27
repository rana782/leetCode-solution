// LeetCode: Divide Array in Sets of K Consecutive Numbers (divide-array-in-sets-of-k-consecutive-numbers)
// Submission ID: 1522431160
// Language: java
// Timestamp (UTC): 2025-01-27T18:02:12Z

class Solution {


    public static boolean findSux(int nums[], boolean visited[], int i, int k){

        int nextEle = nums[i]+1;
        int count = 1;
        i+=1;


        while(i<nums.length &&  count<k){

            if(!visited[i] && nextEle == nums[i]){
                visited[i] = true;
                count++;
                nextEle+=1;
            }
            i++;
        }

        return count == k;

    }
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;

        boolean visited[] = new boolean[nums.length];

        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++){

            if(!visited[i]){
                visited[i] = true;
                if(!findSux(nums,visited,i,k)) return false;
            }
        }

        return true;
    }
}