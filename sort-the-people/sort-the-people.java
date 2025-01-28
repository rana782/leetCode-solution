// LeetCode: Sort the People (sort-the-people)
// Submission ID: 1523522326
// Language: java
// Timestamp (UTC): 2025-01-28T17:33:10Z

class Solution {
    public class Pair implements Comparable<Pair>{
        String naam;
        int lambai;

        Pair(String naam, int lambai){
            this.naam = naam;
            this.lambai = lambai;
        }

        public int compareTo(Pair o){
            return this.lambai-o.lambai;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Pair> schema = new ArrayList<>();

        for(int i = 0; i<names.length; i++){
            schema.add(new Pair(names[i],heights[i]));
        }
        Collections.sort(schema,Collections.reverseOrder());

        String output[] = new String[names.length];
         int idx = 0;

         for(Pair p : schema){
            output[idx++] = p.naam;
         }

         return output;
    }
}