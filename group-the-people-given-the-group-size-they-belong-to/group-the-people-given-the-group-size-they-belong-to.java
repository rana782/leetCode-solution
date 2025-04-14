// LeetCode: Group the People Given the Group Size They Belong To (group-the-people-given-the-group-size-they-belong-to)
// Submission ID: 1606903881
// Language: java
// Timestamp (UTC): 2025-04-14T18:51:32Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele;
         int grpSize;
         Pair(int ele,int grpSize){
            this.ele = ele;
            this.grpSize = grpSize;
         }

         public int compareTo(Pair o){
            return this.grpSize-o.grpSize;
         }
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Pair>list = new ArrayList<>();

        for(int i = 0; i<groupSizes.length; i++){
            list.add(new Pair(i,groupSizes[i]));
        }

        Collections.sort(list);

        List<List<Integer>> output = new ArrayList<>();

        int idx = 0;

        while(idx<list.size()){
            int itr = list.get(idx).grpSize;
            List<Integer>subAns = new ArrayList<>();
            for(int i = 0; i<itr; i++){
                    subAns.add(list.get(idx).ele);
                    idx++;
            }

            output.add(subAns);
        }

        return output;
    }
}