// LeetCode: Find K Closest Elements (find-k-closest-elements)
// Submission ID: 1670212086
// Language: java
// Timestamp (UTC): 2025-06-20T06:40:38Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int num,diff;

        Pair(int num, int diff){
            this.num = num;
            this.diff = diff;
        }
        
        public int compareTo(Pair o){
            if(this.diff == o.diff)return this.num-o.num;
            return this.diff-o.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele : arr){
            Pair p = new Pair(ele,Math.abs(ele-x));
            if(pq.size()<k)pq.add(p);
            else if (pq.peek().diff > p.diff || 
        (pq.peek().diff == p.diff && pq.peek().num > p.num)) {
    pq.poll();
    pq.add(p);
}

        }

        List<Integer>output = new ArrayList<>();

        while(!pq.isEmpty()){
            output.add(pq.poll().num);
        }

        System.out.println(output);
    Collections.sort(output);

    return output;
    }
}