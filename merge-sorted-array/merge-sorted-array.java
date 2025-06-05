// LeetCode: Merge Sorted Array (merge-sorted-array)
// Submission ID: 1654978464
// Language: java
// Timestamp (UTC): 2025-06-05T17:46:21Z

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer>output = new ArrayList<>();
        
        for(int i = 0; i<m; i++){
            output.add(nums1[i]);
        }
        
        for(int i = 0; i<n; i++){
            output.add(nums2[i]);
        }
        
        Collections.sort(output);
        
        
        
        for(int i = 0; i<output.size(); i++){
            nums1[i] = output.get(i);
        }
    }
}