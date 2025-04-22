// LeetCode: Remove Interval (remove-interval)
// Submission ID: 1614513933
// Language: java
// Timestamp (UTC): 2025-04-22T10:43:19Z

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
         Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));

         int low = toBeRemoved[0];
         int high = toBeRemoved[1];

         List<List<Integer>>output = new ArrayList<>();
         List<Integer>subAns = new ArrayList<>();

         for(int i = 0; i<intervals.length; i++){
            int first = intervals[i][0];
            int last = intervals[i][1];

            if(first>=low && last<=high)continue;
            else if(first<low && last>high){
                subAns = new ArrayList<>();
                subAns.add(first);
                subAns.add(low);
                output.add(subAns);
                subAns = new ArrayList<>();
                subAns.add(high);
                subAns.add(last);
                output.add(subAns);
            }
           else if(first<=high && last>high){
                subAns = new ArrayList<>();
                subAns.add(high);
                subAns.add(last);
                output.add(subAns);
            }
            else if( first<low && last>=low){
                subAns = new ArrayList<>();
                subAns.add(first);
                subAns.add(low);
                output.add(subAns);
            }
            else{
                subAns = new ArrayList<>();
                subAns.add(first);
                subAns.add(last);
                output.add(subAns);
            }
         }

         return output;
    }
}