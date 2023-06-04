// LeetCode: Partition Array According to Given Pivot (partition-array-according-to-given-pivot)
// Submission ID: 1561190792
// Language: java
// Timestamp (UTC): 2025-03-03T07:51:46Z

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
            arr[k]=nums[i];
            k++;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==pivot)
            {
                arr[k]=nums[i];
                k++;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>pivot)
            {
                arr[k]=nums[i];
                k++;
            }
        }
        return arr;
        
    }
}