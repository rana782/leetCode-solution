// LeetCode: Index Pairs of a String (index-pairs-of-a-string)
// Submission ID: 1612413275
// Language: java
// Timestamp (UTC): 2025-04-20T10:20:48Z

class Solution {
    public static class Pair{
        int i;
        int j;

        Pair(int i , int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] indexPairs(String text, String[] words) {
        HashSet<String>set = new HashSet<>();
        
        for(String str : words){
            set.add(str);
        }

        List<Pair>list = new ArrayList<>();

        for(int i = 0; i<text.length(); i++){
            for(int j = i; j<text.length(); j++){

                String str = text.substring(i,j+1);

                if(set.contains(str)){
                    list.add(new Pair(i,j));
                }
            }
        }

        int output[][] = new int[list.size()][2];
        int idx = 0;
        for(Pair p : list){
                output[idx][0] = p.i;
                output[idx][1] = p.j;
                idx++;
        }

        return output;
    }
}