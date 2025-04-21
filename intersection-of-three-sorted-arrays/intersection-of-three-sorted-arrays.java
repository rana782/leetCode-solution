// LeetCode: Intersection of Three Sorted Arrays (intersection-of-three-sorted-arrays)
// Submission ID: 1613607957
// Language: java
// Timestamp (UTC): 2025-04-21T14:10:54Z

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int common[] = new int[2001];

        for(int i = 0; i<arr1.length; i++){
            common[arr1[i]]++;
        }

                for(int i = 0; i<arr2.length; i++){
            common[arr2[i]]++;
        }

                for(int i = 0; i<arr3.length; i++){
              common[arr3[i]]++;
        }


        List<Integer>output = new ArrayList<>();

        for(int i = 0; i<common.length; i++){
            if(common[i] == 3)output.add(i);
        }

        return output;
    }
}