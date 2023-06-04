// LeetCode: Meeting Rooms II (meeting-rooms-ii)
// Submission ID: 1633844462
// Language: java
// Timestamp (UTC): 2025-05-14T15:28:14Z

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int in[] : intervals){
            int start = in[0];
             int end = in[1];

             map.put(start,map.getOrDefault(start,0)+1);
             map.put(end,map.getOrDefault(end,0)-1);
        }

        int output = Integer.MIN_VALUE;
         int sum = 0;

         for(int ele : map.values()){
            sum+=ele;
            output = Math.max(sum,output);
         }

         return output;
    }
}