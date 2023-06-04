// LeetCode: N-Queens (n-queens)
// Submission ID: 1353172043
// Language: java
// Timestamp (UTC): 2024-08-12T13:49:00Z

class Solution {

    public static List<String> convert(char chess[][]){
		List<String> ans = new ArrayList<>();
		
		for(int i = 0; i<chess.length; i++) {
			ans.add(new String(chess[i]));
		}
		return ans;
	}
	public static boolean isSafe(char chess[][], int row, int col) {
		for(int i = row-1,j = col; i>=0; i--) {
			if(chess[i][j] == 'Q') {
				return false;
			}
		}
		
		for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
			if(chess[i][j] == 'Q') {
				return false;
			}
		}
		
		for(int i = row-1, j = col+1; i>=0 && j<chess[0].length; i--, j++) {
			if(chess[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
		
	}

	public static void solution(char chess[][],List<List<String>>output, int row) {
		if(row == chess.length) {
			output.add(convert(chess));
			return;
		}
		
		for(int col = 0; col<chess[0].length; col++) {
			
			if(isSafe(chess,row,col)){
				chess[row][col] = 'Q';
				solution(chess,output, row+1);
				chess[row][col] = '.';
			}
			
		}
	}
    public List<List<String>> solveNQueens(int n) {
        char arr[][] = new char[n][n];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[0].length; j++) {
				arr[i][j] = '.';
			}
		}
		List<List<String>>output = new ArrayList<>();
		solution(arr,output, 0);
        return output;
    }
}