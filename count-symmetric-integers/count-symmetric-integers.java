// LeetCode:   Count Symmetric Integers (count-symmetric-integers)
// Submission ID: 1603574165
// Language: java
// Timestamp (UTC): 2025-04-11T10:58:53Z

class Solution {
	public static boolean check(int num) {
		char arr[] = String.valueOf(num).toCharArray();
		
		int first = 0;
		
		int sec = 0;
		if(arr.length%2!=0)return false;
		
		for(int i = 0; i<arr.length/2; i++) {
			first+=arr[i]-'0';
		}
		
		for(int i = arr.length/2; i<arr.length; i++) {
			sec+=arr[i]-'0';
		}
		
		return first == sec;
	}
	
    public int countSymmetricIntegers(int low, int high) {
        
    	int count = 0;
    	
    	for(int i = low; i<=high; i++) {
    		
    			
    			if(check(i))count++;
    		
    	}
    	
    	return count;
    }
}