// LeetCode: Largest Substring Between Two Equal Characters (largest-substring-between-two-equal-characters)
// Submission ID: 1557070647
// Language: java
// Timestamp (UTC): 2025-02-27T11:19:46Z

class Solution {
   
	 public static int maxLengthBetweenEqualCharacters(String s) {
	        HashMap<Character, int[]>map = new HashMap<>();
	        
	        for(int i = 0; i<s.length(); i++) {
	        	char ch = s.charAt(i);
	        	
	        	if(map.containsKey(ch)) {
	        		int arr[] = map.get(ch);
	        		arr[1] = i;
	        		map.put(ch, arr);
	        	}
	        	
	        	else {
	        		int arr[] = new int[2];
	        		arr[0] = i;
	        		map.put(ch,arr);
	        	}
	        }
	        
	        int output = -1;
	        
	        for(char ch : map.keySet()) {
	        	int arr[] = map.get(ch);
	        	
	        	int currLength = arr[1]-arr[0]-1;
	        	
	        	if(currLength>=0) output = Math.max(currLength, output);
	        }
	        
	        return output;
	    }
}