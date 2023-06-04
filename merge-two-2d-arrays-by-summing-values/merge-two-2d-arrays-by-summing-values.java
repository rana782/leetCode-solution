// LeetCode: Merge Two 2D Arrays by Summing Values (merge-two-2d-arrays-by-summing-values)
// Submission ID: 1560089704
// Language: java
// Timestamp (UTC): 2025-03-02T06:56:29Z

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

      for(int num[] : nums1){
        int id = num[0];
        int val = num[1];

        map.put(id,map.getOrDefault(id,0)+val);
      }

        for(int num[] : nums2){
        int id = num[0];
        int val = num[1];

        map.put(id,map.getOrDefault(id,0)+val);
      }

      int size = map.size();

      int output[][] = new int[size][2];
       int idx = 0;
      for(int num : map.keySet()){
           int id = num;
           int val = map.get(num);
           output[idx][0] = id;
           output[idx][1] = val;
           idx++;
      }

      Arrays.sort(output,(a,b)-> Integer.compare(a[0],b[0]));
      return output;
    }
}