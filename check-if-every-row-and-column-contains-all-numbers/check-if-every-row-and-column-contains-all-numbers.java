// LeetCode: Check if Every Row and Column Contains All Numbers (check-if-every-row-and-column-contains-all-numbers)
// Submission ID: 1341102925
// Language: java
// Timestamp (UTC): 2024-08-01T18:47:16Z

class Solution {
 
    public boolean checkValid(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            HashSet<Integer> map = new HashSet<>();
            for(int j = 0; j<matrix[0].length; j++){
                if(map.contains(matrix[i][j])){
                    return false;
                }
                else{
                    map.add(matrix[i][j]);
                }
            }
        }

            for(int i = 0; i<matrix.length; i++){
            HashSet<Integer> map = new HashSet<>();
            for(int j = 0; j<matrix[0].length; j++){
                if(map.contains(matrix[j][i])){
                    return false;
                }
                else{
                    map.add(matrix[j][i]);
                }
            }
        }
        return true;
    }
}