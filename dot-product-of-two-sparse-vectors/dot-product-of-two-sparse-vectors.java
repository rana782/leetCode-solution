// LeetCode: Dot Product of Two Sparse Vectors (dot-product-of-two-sparse-vectors)
// Submission ID: 1659353641
// Language: java
// Timestamp (UTC): 2025-06-10T05:21:29Z

class SparseVector {
    HashMap<Integer,Integer>map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0)map.put(i,nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        
       for(int idx : this.map.keySet()){
           
           if(vec.map.containsKey(idx)){
               res+=this.map.get(idx)*vec.map.get(idx);
           }
       }
        
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);