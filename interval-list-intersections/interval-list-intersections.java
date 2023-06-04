// LeetCode: Interval List Intersections (interval-list-intersections)
// Submission ID: 1634696615
// Language: java
// Timestamp (UTC): 2025-05-15T13:53:55Z

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>>output = new ArrayList<>();

        int n1 = firstList.length;
        int n2 = secondList.length;

        int l1 = 0,l2 = 0;

        while(l1<n1 && l2<n2){
                    int start = Math.max(firstList[l1][0],secondList[l2][0]);
                    int end = Math.min(firstList[l1][1],secondList[l2][1]);

                    if(end>=start){
                        List<Integer>subAns = new ArrayList<>();
                        subAns.add(start);
                        subAns.add(end);
                        output.add(subAns);
                    }

                    int endPt1 = firstList[l1][1];
                    int endPt2 = secondList[l2][1];

                    if(endPt1 == endPt2){
                        l1++;
                        l2++;
                    }
                    else if(endPt1<endPt2){
                        l1++;
                    }
                    else{
                        l2++;
                    }
        }

        int res[][] = new int[output.size()][2];
         int idx = 0;

         for(List<Integer> l : output){
            res[idx][0] = l.get(0);
            res[idx][1] = l.get(1);
            idx++;
         }

         return res;
    }
}