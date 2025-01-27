// LeetCode: Degree of an Array (degree-of-an-array)
// Submission ID: 1521845447
// Language: java
// Timestamp (UTC): 2025-01-27T06:54:31Z

class Solution {


    public static int[] getIdx(int x, int nums[]){
        int output[] = new int[2];
        Arrays.fill(output,-1);

        for(int i =0; i<nums.length; i++){

            if(x == nums[i]){

                if(output[0] == -1){
                    output[0] = i;
                    
            }
                       output[1] = i;
            
            }
        }

        return output;
    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
          int maxDegree = 0;
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            maxDegree = Math.max(maxDegree,map.get(nums[i]));
        }

        int maxLength = Integer.MAX_VALUE;;

        for(int i : map.keySet()){
            if(maxDegree == map.get(i)){

                int arr[] = getIdx(i,nums);

                int len = arr[1]-arr[0]+1;

                maxLength = Math.min(maxLength,len);
            }
        }

        return maxLength;
    }
}