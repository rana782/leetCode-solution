// LeetCode: Zigzag Conversion (zigzag-conversion)
// Submission ID: 1538208661
// Language: java
// Timestamp (UTC): 2025-02-10T15:09:57Z

class Solution {
       public String convert(String s, int numRows) {
        if(s.length() <= numRows) return s;

        if(numRows == 1) return s;
        
        ArrayList<ArrayList<Character>> output = new ArrayList<>();
        
        for(int i =0; i<numRows; i++) {
        	output.add(new ArrayList<>());
        }
        
        for(int i = 0;i<numRows; i++) {
        
        	output.get(i).add(s.charAt(i));
        }
        
        int idx = numRows;
        int count = 1;
        
        
        while(idx<s.length()) {
        	
        	if(count%2 == 1) {
        		for(int i = output.size()-2; i>=0; i--) {
        			if(idx>=s.length()) break;
        			
        			else {
        				output.get(i).add(s.charAt(idx));
        				idx++;
        			}
        		}
        	}
        	
        	else {
        		
        		for(int i = 1; i<output.size(); i++) {
        			if(idx>=s.length()) break;
        			
        			else {
        				output.get(i).add(s.charAt(idx));
        				idx++;
        			}
        		}
        	}
        	
        	count++;
        }
        
        
        StringBuilder ans = new StringBuilder();
        
        for(ArrayList<Character> subAns : output) {
        	for(char ch : subAns) {
        		ans.append(ch);
        	}
        }
        
        return ans.toString();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

    }
}