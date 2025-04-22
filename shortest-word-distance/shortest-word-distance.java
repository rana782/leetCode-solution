// LeetCode: Shortest Word Distance (shortest-word-distance)
// Submission ID: 1614530652
// Language: java
// Timestamp (UTC): 2025-04-22T11:04:40Z

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String,List<Integer>>map = new HashMap<>();

        for(int i = 0; i<wordsDict.length; i++){
            String str = wordsDict[i];

            if(str.equals(word1) || str.equals(word2)){

                List<Integer>list = map.getOrDefault(str, new ArrayList<>());
                list.add(i);
                map.put(str,list);
            }
        }


        List<Integer>l1 = map.get(word1);
        List<Integer>l2 = map.get(word2);

        int output = Integer.MAX_VALUE;

        for(int i = 0; i<l1.size(); i++){
            for(int j = 0; j<l2.size(); j++){
                int diff = Math.abs(l1.get(i)-l2.get(j));
                if(diff == 1)return 1;

                output = Math.min(output,diff);
            }
        }

        return output;
    }
}