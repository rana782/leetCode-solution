// LeetCode: Shortest Word Distance II (shortest-word-distance-ii)
// Submission ID: 1635049243
// Language: java
// Timestamp (UTC): 2025-05-15T21:38:58Z

class WordDistance {
    HashMap<String, List<Integer>>map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        for(int i = 0; i<wordsDict.length; i++){
            String str = wordsDict[i];
            List<Integer>subAns = map.getOrDefault(str,new ArrayList<>());
            subAns.add(i);
            map.put(str,subAns);
        }

    }
    
    public int shortest(String word1, String word2) {
        int output = Integer.MAX_VALUE;
        List<Integer>l1 = map.get(word1);
        List<Integer>l2 = map.get(word2);

        for(int i : l1){
            for(int j : l2){
                int diff = Math.abs(i-j);
                output = Math.min(output,diff);
            }
        }

        return output;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */