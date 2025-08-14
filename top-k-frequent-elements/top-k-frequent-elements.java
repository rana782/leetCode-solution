// LeetCode: Top K Frequent Elements (top-k-frequent-elements)
// Submission ID: 1735319760
// Language: java
// Timestamp (UTC): 2025-08-14T19:06:08Z

class Solution {
    public static class Pair implements Comparable<Pair>{
            int num,freq;

            Pair(int num, int freq){
                this.num = num;
                this.freq = freq;
            }
            public int compareTo(Pair o){
                return this.freq-o.freq;
            }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>();

        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        for(int key : map.keySet()){
            Pair p = new Pair(key,map.get(key));
            if(pq.size()<k)pq.add(p);
            else if(pq.peek().freq<p.freq){
                    pq.poll();
                    pq.add(p);
            }
        }

        int output[] = new int[k];
         int idx = 0;

         while(!pq.isEmpty()){
            output[idx++] = pq.poll().num;
         }

         return output;

    }
}