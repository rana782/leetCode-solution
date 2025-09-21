class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int output = 0;

        for(int ele : nums){
            if(ele%2 == 0){
                output|=ele;
            }
        }

        return output;
    }
}