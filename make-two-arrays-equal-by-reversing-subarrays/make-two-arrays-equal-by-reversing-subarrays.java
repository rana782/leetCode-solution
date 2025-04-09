// LeetCode: Make Two Arrays Equal by Reversing Subarrays (make-two-arrays-equal-by-reversing-subarrays)
// Submission ID: 1601687254
// Language: java
// Timestamp (UTC): 2025-04-09T13:19:38Z

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int ele : target){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        for(int ele : arr){
            if(!map.containsKey(ele))return false;

            else{
                
                map.put(ele,map.get(ele)-1);
                if(map.get(ele) == 0)map.remove(ele);
            }
        }

        return map.size() == 0;
    }
}