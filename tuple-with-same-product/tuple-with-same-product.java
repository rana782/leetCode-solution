// LeetCode: Tuple with Same Product (tuple-with-same-product)
// Submission ID: 1533233838
// Language: java
// Timestamp (UTC): 2025-02-06T06:16:55Z

class Solution {
    public int tupleSameProduct(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();

        int ans = 0;

        for(int i = 0; i<nums.length-1; i++){

            for(int j = i+1; j<nums.length; j++){
                int product = nums[i]*nums[j];

              if(map.containsKey(product)){
                map.put(product,map.get(product)+1);
                ans+=(8*map.get(product));
              }
              else{
                map.put(product,0);
              }
            }
        }


        return ans;
    }
}