// LeetCode: Letter Tile Possibilities (letter-tile-possibilities)
// Submission ID: 1546239579
// Language: java
// Timestamp (UTC): 2025-02-17T13:39:41Z

class Solution {
    	static HashSet<String> set;
	
	public static void solution(String tile, boolean visited[], String psf, int limit) {
		if(psf.length()>limit) return;
		
		if(psf.length() == limit) {
		
			set.add(psf);
			return;
		}
		
		for(int i = 0; i<tile.length(); i++) {
			if(!visited[i]) {
				char ch = tile.charAt(i);
				visited[i] = true;
				solution(tile,visited,psf+ch,limit);
				visited[i] = false;
			}
		}
	}
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();

        boolean visited[] = new boolean[tiles.length()];

        for(int i = 0; i<tiles.length(); i++){
                solution(tiles,visited,"",i+1);
        }

        return set.size();
       


    }
}