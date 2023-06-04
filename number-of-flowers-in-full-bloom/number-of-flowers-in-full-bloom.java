// LeetCode: Number of Flowers in Full Bloom (number-of-flowers-in-full-bloom)
// Submission ID: 1633891773
// Language: java
// Timestamp (UTC): 2025-05-14T16:24:37Z

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,Integer>map = new TreeMap<>();

        for(int in[] : flowers){
                int start = in[0];
                 int end = in[1]+1;
                 map.put(start,map.getOrDefault(start,0)+1);
                 map.put(end,map.getOrDefault(end,0)-1);
        }

        int prefixSum = 0;
        for(int key : map.keySet()){
            prefixSum+=map.get(key);
            map.put(key,prefixSum);
        }

        int output[] = new int[people.length];

        for(int i = 0; i<people.length; i++){
            

            Integer key = map.floorKey(people[i]);
            output[i] = (key == null) ? 0 : map.get(key);

            

          
        }

        return output;
    }
}