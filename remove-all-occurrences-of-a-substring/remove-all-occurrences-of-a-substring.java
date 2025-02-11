// LeetCode: Remove All Occurrences of a Substring (remove-all-occurrences-of-a-substring)
// Submission ID: 1538976680
// Language: java
// Timestamp (UTC): 2025-02-11T06:52:48Z

class Solution {
   
	 public static String removeOccurrences(String s, String part) {
	        StringBuilder str = new StringBuilder(s);
	       int len = part.length();
	       
	       int firstIdx = 0;
	       
	       while(firstIdx!=-1) {
	    	   firstIdx = str.indexOf(part);
	    	   
	    	   if(firstIdx!=-1) {
	    		   int lastIdx = firstIdx+len;
	    		   str.delete(firstIdx, lastIdx);
	    	   }
	       }
	       
	       return str.toString();
	    }
}