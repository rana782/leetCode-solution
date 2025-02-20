// LeetCode: Baseball Game (baseball-game)
// Submission ID: 1549993954
// Language: java
// Timestamp (UTC): 2025-02-20T19:01:15Z

class Solution {
    	  public int calPoints(String[] operations) {
	        ArrayList<Integer> output = new ArrayList<>();
	        
	        for(int i = 0; i<operations.length; i++) {
	        	String str = operations[i];
	        	if(str.equals("C")) {
	        		output.remove(output.size()-1);
	        	}
	        	
	        	else if(str.equals("+")) {
	        		int sum = output.get(output.size()-1)+output.get(output.size()-2);	
	        		output.add(sum);
	        	}
	        	
	        	else if(str.equals("D")) {
	        		int sum = output.get(output.size()-1)*2;
	        		output.add(sum);
	        	}
	        	
	        	else {
	        		output.add(Integer.parseInt(str));
	        	}
	        }
	        
	        int sum = 0;
	        
	        for(int i : output) {
	        	sum+=i;
	        }
	        
	        return sum;
	  }
}