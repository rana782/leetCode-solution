class Solution {
    public static int findMin(int arr[]){
        int output = Integer.MAX_VALUE;

        for(int ele : arr){
            output = Math.min(output,ele);
        }

        return output;
    }

    public static int getDigitSum(int ele){
        int output = 0;
        while(ele!=0){
            int rem = ele%10;
            output+=rem;
            ele/=10;
        }

        return output;
    }
    public int sumOfDigits(int[] nums) {
        int minNum = findMin(nums);
        int digitSum = getDigitSum(minNum);

        return digitSum%2 == 1 ? 0 : 1;
    }
}