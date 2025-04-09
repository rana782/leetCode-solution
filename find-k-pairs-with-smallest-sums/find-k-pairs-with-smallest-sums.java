// LeetCode: Find K Pairs with Smallest Sums (find-k-pairs-with-smallest-sums)
// Submission ID: 1601986044
// Language: java
// Timestamp (UTC): 2025-04-09T18:27:48Z

class Solution {
   	public class Triplet implements Comparable<Triplet>{
		int first;
		 int sec;
		  int sum;
		  
		  Triplet(int first, int sec, int sum){
			  this.first = first;
			  this.sec = sec;
			  this.sum = sum;
		  }
		  
		  public int compareTo(Triplet o) {
			  return this.sum-o.sum;
					  
		  }

		  
	}
	
	   public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        
		   PriorityQueue<Triplet>pq = new PriorityQueue<>(Collections.reverseOrder());
		   
		   List<List<Integer>>output = new ArrayList<>();
		   
		   for(int i = 0; i<nums1.length; i++) {
			   for(int j = 0; j<nums2.length; j++) {
				   
				   Triplet t = new Triplet(nums1[i],nums2[j],nums1[i]+nums2[j]);
				   
				 if(pq.size()<k)pq.add(t);

                 else if(pq.peek().sum>t.sum){
                    pq.poll();
                        pq.add(t);
                 }

                 else{
                    break;
                 }
			   }
		   }
		   
		   
		   while(pq.size()!=0) {
			   Triplet t = pq.poll();
			   
			   List<Integer>l = new ArrayList<>();
			   l.add(t.first);
			   l.add(t.sec);
			   
			   output.add(l);
		   }
		   
		   return output;
	    }
}