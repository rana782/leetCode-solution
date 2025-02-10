// LeetCode: Kth Distinct String in an Array (kth-distinct-string-in-an-array)
// Submission ID: 1538421146
// Language: java
// Timestamp (UTC): 2025-02-10T18:12:29Z

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        ArrayList<String> distinctString = new ArrayList<>();

       for(int i = 0; i<arr.length; i++){
        if(map.get(arr[i]) == 1){
            distinctString.add(arr[i]);
        }
       }

        if(distinctString.size()<k){
            String output = "";
            return output;
        }
        
        return distinctString.get(k-1);
    }
}