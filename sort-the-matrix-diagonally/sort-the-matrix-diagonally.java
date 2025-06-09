// LeetCode: Sort the Matrix Diagonally (sort-the-matrix-diagonally)
// Submission ID: 1658229413
// Language: java
// Timestamp (UTC): 2025-06-09T04:26:06Z

class Solution {
    public static class Pair{
        List<Integer>l;
        int idx;
        Pair(List<Integer>l, int idx){
            this.l = l;
            this.idx = idx;
        }
    }
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,Pair>map = new HashMap<>();
        
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                int diff = i-j;
                
                Pair p = map.getOrDefault(diff,new Pair(new ArrayList<>(),0));
               p.l.add(mat[i][j]);
                map.put(diff,p);
            }
        }
        
        for(int key : map.keySet()){
            
            Pair p = map.get(key);
            Collections.sort(p.l);
        }
        
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                int diff = i-j;
                Pair p = map.get(diff);
               
                mat[i][j] = p.l.get(p.idx);
                p.idx++;
            }
        }
        
        return mat;
        
    }
}