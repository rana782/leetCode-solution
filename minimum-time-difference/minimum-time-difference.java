// LeetCode: Minimum Time Difference (minimum-time-difference)
// Submission ID: 1609536621
// Language: java
// Timestamp (UTC): 2025-04-17T13:02:28Z

class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        List<Integer>res = new ArrayList<>();
         
         	for(int i = 0;i<timePoints.size(); i++) {
         		
         		String str = timePoints.get(i);
         		
         		String hours = str.substring(0, 2);
         		String minutes = str.substring(3);
         		
         		int hrs = Integer.parseInt(hours);
         		int mint = Integer.parseInt(minutes);
         		
         		
         		
         		int val = (hrs*60)+mint;
                 res.add(val);	
         	}

             Collections.sort(res);
             
             int diff = Integer.MAX_VALUE;
             
             for(int i = 0; i<res.size()-1; i++) {
            	 int currDiff = res.get(i+1)-res.get(i);
            	diff =  Math.min(diff, currDiff);
             }
             
             int currDiff = 1440-(res.get(res.size()-1)-res.get(0));
             
         	diff = Math.min(diff, currDiff);
         	
         	return diff;
         
     }
}