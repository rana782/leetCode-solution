// LeetCode: Sort Array By Parity (sort-array-by-parity)
// Submission ID: 1659233786
// Language: java
// Timestamp (UTC): 2025-06-10T02:54:43Z

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer>even = new ArrayList<>();
        List<Integer>odd = new ArrayList<>();
        
        for(int ele : nums){
            if(ele%2 == 0)even.add(ele);
            else{
                odd.add(ele);
            }
        }
        
        int output[] = new int[nums.length];
        int idx = 0;
        
        for(int ele : even){
            output[idx++] = ele;
        }
        
        for(int ele : odd){
            output[idx++] = ele;
        }
        
        return output;
    }
}