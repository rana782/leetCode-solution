// LeetCode: Relative Ranks (relative-ranks)
// Submission ID: 1509674941
// Language: java
// Timestamp (UTC): 2025-01-15T18:16:38Z

class Solution {
   	 public String[] findRelativeRanks(int[] score) {
		 int size = score.length;
	        Integer copyArr[] = new Integer[size];
	        
	        for(int i = 0; i<size; i++) {
	        	copyArr[i] = score[i];
	        }
	        
	        Arrays.sort(copyArr,Collections.reverseOrder());
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for(int i = 0; i<copyArr.length; i++) {
	        	map.put(copyArr[i],i+1);
	        }
	        
	        String[] output = new String[size];
	        
	        for(int i = 0; i<size; i++) {
	        	if(map.get(score[i]) == 1) {
	        		output[i] = "Gold Medal";
	        	}
	        	
	        	else if(map.get(score[i]) == 2) {
	        		output[i] = "Silver Medal";
	        	}
	        	
	        	else if(map.get(score[i]) == 3) {
	        		output[i] = "Bronze Medal";
	        	}
	        	else {
	        		output[i] = String.valueOf(map.get(score[i]));
	        	}
	        }
	        
	        return output;
	    }
}