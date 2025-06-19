// LeetCode: Find Anagram Mappings (find-anagram-mappings)
// Submission ID: 1668999976
// Language: java
// Timestamp (UTC): 2025-06-19T05:19:53Z

class Solution {
    public static class Pair{
        int idx;
        List<Integer>l;
        
        Pair(int idx, List<Integer>l){
            this.idx = idx;
            this.l = l;
        }
    }
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        int output[] = new int[n];
        
        HashMap<Integer,Pair>map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            
            Pair p = map.getOrDefault(nums2[i],new Pair(0,new ArrayList<>()));
            p.l.add(i);
            map.put(nums2[i],p);
        }
        
        for(int i = 0; i<nums1.length; i++){
            Pair p = map.get(nums1[i]);
            
            int idx = p.idx;
            output[i] = p.l.get(idx);
            p.idx++;
        }
        
        return output;
    }
}