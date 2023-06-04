// LeetCode: Meeting Scheduler (meeting-scheduler)
// Submission ID: 1637267763
// Language: java
// Timestamp (UTC): 2025-05-18T12:07:24Z

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,(a,b)->Integer.compare(a[0], b[0]));
        Arrays.sort(slots2,(a,b)->Integer.compare(a[0], b[0]));
        int m = slots1.length;
         int n = slots2.length;

         int i = 0; 
         int j = 0;

  
         List<Integer>output = new ArrayList<>();

         while(i<m && j<n){
            int start = Math.max(slots1[i][0],slots2[j][0]);
            int end = Math.min(slots1[i][1],slots2[j][1]);

           if(start<=end){
             if(start+duration<=end){
                output.add(start);
                output.add(start+duration);
                return output;
             }
           }

           if(slots1[i][1]<slots2[j][1])i++;
           else{
            j++;
           }
            }
         
       

        return output;
    }
}