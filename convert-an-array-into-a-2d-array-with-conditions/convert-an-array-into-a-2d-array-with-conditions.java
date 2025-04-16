// LeetCode: Convert an Array Into a 2D Array With Conditions (convert-an-array-into-a-2d-array-with-conditions)
// Submission ID: 1608780107
// Language: java
// Timestamp (UTC): 2025-04-16T17:36:16Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele;
         int freq;

         Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
         }

         public int compareTo(Pair o){
            return this.freq-o.freq;
         }
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>>output = new ArrayList<>();
      HashMap<Integer,Integer>map = new HashMap<>();

       for(int i = 0; i<nums.length; i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }

       List<Pair>list = new ArrayList<>();

       for(int ele : map.keySet()){
        list.add(new Pair(ele,map.get(ele)));
       }

       list.sort(Collections.reverseOrder());

       Pair p = list.get(0);
       int freq = p.freq;

       for(int i = 0; i<freq; i++){
        output.add(new ArrayList<>());
       }

       for(Pair pr : list){
        int num = pr.ele;
        int itr = pr.freq;

        for(int i = 0; i<itr; i++){
            output.get(i).add(num);
        }
       }



        return output;
    }
}