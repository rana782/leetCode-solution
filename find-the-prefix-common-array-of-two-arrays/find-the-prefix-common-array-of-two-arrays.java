// LeetCode: Find the Prefix Common Array of Two Arrays (find-the-prefix-common-array-of-two-arrays)
// Submission ID: 1508025053
// Language: java
// Timestamp (UTC): 2025-01-14T06:17:10Z

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
	int size = A.length;
        int commomPreFixArray[] = new int[size];
        
        int count = 0;
        
        HashSet<Integer> commonElement = new HashSet<>();
        
        for(int i = 0; i<A.length; i++) {
        	commonElement.add(A[i]);
        	commonElement.add(B[i]);
        	count+=2;
        	int commonNums = count-commonElement.size();
        	commomPreFixArray[i] = commonNums;
        }
        
        return commomPreFixArray;
    }
}