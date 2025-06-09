// LeetCode: Intersection of Two Arrays (intersection-of-two-arrays)
// Submission ID: 1659047249
// Language: java
// Timestamp (UTC): 2025-06-09T20:10:17Z

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set1 = new HashSet<>();
        HashSet<Integer>set2 = new HashSet<>();
        
        for(int ele : nums1){
            set1.add(ele);
        }
        
        for(int ele : nums2){
            set2.add(ele);
        }
        
        List<Integer>res = new ArrayList<>();
        
        for(int ele : set1){
            if(set2.contains(ele))res.add(ele);
        }
        
        
        System.out.println(res);
        
        int output[] = new int[res.size()];
        
        for(int i = 0; i<output.length; i++){
            output[i] = res.get(i);
        }
        
        return output;
    }
}