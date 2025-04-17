// LeetCode: Find All Groups of Farmland (find-all-groups-of-farmland)
// Submission ID: 1609175870
// Language: java
// Timestamp (UTC): 2025-04-17T04:53:17Z

class Solution {
	static int m;
	static int n;
	static int row,col;
	static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>>points = new ArrayList<>();
        m = land.length;
        n = land[0].length;
        
        
        
        boolean visited[][] = new boolean[m][n];
        
        for(int i = 0; i<m; i++) {
        	for(int j = 0;j<n; j++) {
        		
        		if(!visited[i][j]&&land[i][j] == 1) {
        			row = Integer.MIN_VALUE;
        			col = Integer.MIN_VALUE;
        			
        			List<Integer>subAns = new ArrayList<>();
        			subAns.add(i);
        			subAns.add(j);
        			
        			dfs(i,j,visited,land);
        			subAns.add(row);
        			subAns.add(col);
        			
        			points.add(subAns);
        		}
        	}
        }
        
        
        int output[][] = new int[points.size()][4];
        
        for(int i =0;i<points.size(); i++) {
        	
        	List<Integer>list = points.get(i);
        	
        	for(int j = 0; j<list.size(); j++) {
        		output[i][j] = list.get(j);
        	}
        }
        
        
        
        return output;
        
        
    }

	private void dfs(int i, int j, boolean[][] visited, int[][] land) {
	if(i>=row && j>=col) {
		row = i;
		col = j;
	}
	
	visited[i][j] = true;
	
	for(int d[] : dir) {
		int nRow = i+d[0];
		int nCol = j+d[1];
		
		if(nRow>=0 && nCol>=0 &&nRow<m && nCol<n && !visited[nRow][nCol] && land[nRow][nCol] == 1) {
			dfs(nRow, nCol, visited, land);
		}
	}
		
	}
}