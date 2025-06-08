// LeetCode: Random Pick Index (random-pick-index)
// Submission ID: 1658042856
// Language: java
// Timestamp (UTC): 2025-06-08T21:26:06Z

class Solution {
    public static class Pair{
        List<Integer>l;
        int idx;
        
        Pair(List<Integer>l,int idx){
            this.l = l;
            this.idx = idx;
        }
    }
    static HashMap<Integer,Pair>map;
   

    public Solution(int[] nums) {
        map = new HashMap<>();
       
        
        for(int i = 0; i<nums.length; i++){
            Pair p = map.getOrDefault(nums[i],new Pair(new ArrayList<>(),0));
            p.l.add(i);
            
            map.put(nums[i],p);
        }
    }
    
    public int pick(int target) {
        Pair p = map.get(target);
        
        List<Integer>ls = p.l;
        
        int size = ls.size();
        int idx = p.idx;
        
        int output = ls.get(idx%size);
        
        map.put(target,new Pair(ls,idx+1));
        return output;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */