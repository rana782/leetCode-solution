// LeetCode: Delete Characters to Make Fancy String (delete-characters-to-make-fancy-string)
// Submission ID: 1508664570
// Language: java
// Timestamp (UTC): 2025-01-14T18:43:04Z

class Solution {
   public String makeFancyString(String s) {
	
	
        int size = s.length();
        
        if(size == 1 || size == 2)return s;
        
        
        boolean deletionIndex[] = new boolean[size];
        
        
        for(int i = 1; i<size-1; i++) {
        	if(s.charAt(i-1) == s.charAt(i) && s.charAt(i) == s.charAt(i+1)) deletionIndex[i] = true;
        }
        
        StringBuilder output = new StringBuilder();
        
        for(int i = 0; i<size; i++) {
        	if(!deletionIndex[i]) output.append(s.charAt(i));
        }
        
        return output.toString();
    }

}