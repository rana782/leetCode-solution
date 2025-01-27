// LeetCode: Relative Sort Array (relative-sort-array)
// Submission ID: 1522470811
// Language: java
// Timestamp (UTC): 2025-01-27T18:37:15Z

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        Arrays.sort(arr1);

        for(int i = 0; i<arr1.length; i++){

            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }


        int output[] = new int[arr1.length];
        int idx = 0;

        for(int i = 0; i<arr2.length; i++){

            int freq = map.get(arr2[i]);
            visited.add(arr2[i]);
             
             while(freq!=0){
                output[idx++] = arr2[i];
                freq--;
             }

        }


        for(int i =0; i<arr1.length; i++){
            if(!visited.contains(arr1[i])){
                output[idx++] = arr1[i];
            }
        }

        return output;
    }
}