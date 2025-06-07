// LeetCode: Intersection of Two Arrays II (intersection-of-two-arrays-ii)
// Submission ID: 1656891107
// Language: java
// Timestamp (UTC): 2025-06-07T17:53:40Z

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer,Integer>map1 = new HashMap<>(); 
        
         HashMap<Integer,Integer>map2 = new HashMap<>(); 
        
        for(int i = 0; i<nums1.length; i++){
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        
          for(int i = 0; i<nums2.length; i++){
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        
        List<Integer>output = new ArrayList<>();
        
        for(int key : map1.keySet()){
            
            if(map2.containsKey(key)){
                int steps = Math.min(map1.get(key),map2.get(key));
                
                while(steps-->0)output.add(key);
            }
        }
        
        System.out.println(output);
        
        int res[] = new int[output.size()];
        
        for(int i = 0; i<output.size(); i++){
            res[i] = output.get(i);
        }
        
        return res;
    }
}