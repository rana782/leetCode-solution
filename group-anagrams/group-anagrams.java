// LeetCode: Group Anagrams (group-anagrams)
// Submission ID: 1735271623
// Language: java
// Timestamp (UTC): 2025-08-14T18:17:45Z

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map = new  HashMap<>();


        for(String str : strs){

            int arr[] = new int[26];

            for(char ch : str.toCharArray()){
                arr[ch-'a']++;
            }

            String code = Arrays.toString(arr);
            List<String>subList = map.getOrDefault(code,new ArrayList<>());
            subList.add(str);
            map.put(code,subList);
        }

        List<List<String>>output = new ArrayList<>();

        for(List<String>subAns : map.values()){
            output.add(subAns);
        }

        return output;
    }
}