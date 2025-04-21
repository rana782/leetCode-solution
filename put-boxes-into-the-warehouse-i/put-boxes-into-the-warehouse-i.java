// LeetCode: Put Boxes Into the Warehouse I (put-boxes-into-the-warehouse-i)
// Submission ID: 1613907726
// Language: java
// Timestamp (UTC): 2025-04-21T19:12:08Z

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int minHeights[] = new int[warehouse.length];
        minHeights[0] = warehouse[0];

        for(int i = 1; i<warehouse.length; i++){
            minHeights[i] = Math.min(minHeights[i-1],warehouse[i]);
        }

        int output = 0;

        Arrays.sort(boxes);

        int i = 0;
        int j = warehouse.length-1;

        while(i<boxes.length && j>=0){

            if(boxes[i]<=minHeights[j]){
                output++;
                i++;
            }
            j--;
        }

        return output;
    }
}