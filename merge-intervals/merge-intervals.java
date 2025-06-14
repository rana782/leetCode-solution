// LeetCode: Merge Intervals (merge-intervals)
// Submission ID: 1663770162
// Language: java
// Timestamp (UTC): 2025-06-14T10:50:24Z

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
         List<List<Integer>>output = new ArrayList<>();
        
        int i= 0;
        while(i<intervals.length){
            
            int j = i;
            int end = intervals[j][1];
            
            while(j+1<intervals.length && intervals[j+1][0]<=end){
                end = Math.max(end,intervals[j+1][1]);
                j++;
            }
            
            output.add(Arrays.asList(intervals[i][0],end));
            i = j+1;
            
            
        }
        
        System.out.println(output);
        int res[][] = new int[output.size()][2];
       int idx = 0;
        
        for(List<Integer>l : output){
            res[idx][0] = l.get(0);
            res[idx][1] = l.get(1);
            idx++;
        }
        return res;
    }
}