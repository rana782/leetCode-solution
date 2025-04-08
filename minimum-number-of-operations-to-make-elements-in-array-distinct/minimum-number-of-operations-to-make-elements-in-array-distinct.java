// LeetCode: Minimum Number of Operations to Make Elements in Array Distinct (minimum-number-of-operations-to-make-elements-in-array-distinct)
// Submission ID: 1600369513
// Language: java
// Timestamp (UTC): 2025-04-08T07:09:05Z

class Solution {
    public static boolean containDuplicate(int nums[], int idx){
        HashSet<Integer>set = new HashSet<>();

        for(int i = idx; i<nums.length; i++){
            if(set.contains(nums[i]))return true;

            set.add(nums[i]);
        }

        return false;
    }
    public int minimumOperations(int[] nums) {
        
        int idx = 0;
        int count = 0;

        while(idx<nums.length){

            if(containDuplicate(nums,idx)){
                idx+=3;
                count++;
            }
            else{
                break;
            }
        }

        return count;
    }
}