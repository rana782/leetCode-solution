// LeetCode: Find Smallest Common Element in All Rows (find-smallest-common-element-in-all-rows)
// Submission ID: 1613492438
// Language: java
// Timestamp (UTC): 2025-04-21T11:59:11Z

class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if(m == 1)return -1;

        TreeMap<Integer,Integer>map = new TreeMap<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){

                map.put(mat[i][j],map.getOrDefault(mat[i][j],0)+1);
            }
        }

        for(int ele : map.keySet()){
            if(map.get(ele) >= m)return ele;
        }

        return -1;
    }
}