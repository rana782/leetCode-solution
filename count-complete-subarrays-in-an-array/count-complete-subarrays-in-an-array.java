// LeetCode: Count Complete Subarrays in an Array (count-complete-subarrays-in-an-array)
// Submission ID: 1616410793
// Language: java
// Timestamp (UTC): 2025-04-24T07:27:31Z

class Solution {

    public static int atmost(int dist, int nums[]){
        int j = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        int output = 0;

        for(int i = 0; i<nums.length; i++){
            int ele = nums[i];

            map.put(ele,map.getOrDefault(ele,0)+1);

            while(j<=i && map.size()>dist){
                ele = nums[j];

                map.put(ele,map.get(ele)-1);

                if(map.get(ele) == 0)map.remove(ele);
                j++;
            }

            output+=i-j+1;
        }

        return output;
    }
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer>set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        int distEle = set.size();


        int ans1 = atmost(distEle,nums);
        int ans2 = atmost(distEle-1,nums);

        return ans1-ans2;

         

         
    }
}