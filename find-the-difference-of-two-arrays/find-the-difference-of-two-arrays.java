// LeetCode: Find the Difference of Two Arrays (find-the-difference-of-two-arrays)
// Submission ID: 1358837523
// Language: java
// Timestamp (UTC): 2024-08-17T11:34:05Z

class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
	        HashSet<Integer> set1 = new HashSet<>();

	        HashSet<Integer> set2 = new HashSet<>();

	        for(int i : nums1){
	            set1.add(i);
	        }
	          for(int i : nums2){
	            set2.add(i);
	        }

	        List<Integer>l1 = new ArrayList<>();
	         List<Integer>l2 = new ArrayList<>();
	for(int i: nums1){
	    if(set1.contains(i)) {
	    	 if(!set2.contains(i)){
	 	        l1.add(i);
	 	        set1.remove(i);
	 	    }
	    }
	   
	}

	for(int i: nums2){
	    if(set2.contains(i)) {
	    	 if(!set1.contains(i)){
	 	        l2.add(i);
	 	        set2.remove(i);
	 	    }
	    }
	   
	}
	         List<List<Integer>> output = new ArrayList<>();

	         output.add(l1);
	         output.add(l2);
	         return output;

	    }
}