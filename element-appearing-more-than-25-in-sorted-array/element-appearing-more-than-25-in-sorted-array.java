// LeetCode: Element Appearing More Than 25% In Sorted Array (element-appearing-more-than-25-in-sorted-array)
// Submission ID: 1607516029
// Language: java
// Timestamp (UTC): 2025-04-15T12:29:46Z

class Solution {
    public int findSpecialInteger(int[] arr) {

        if(arr.length == 1) return arr[0];
        int prevEle = arr[0];
        int maxCount = 1;
        int currCount = 1;
         int output = arr[0];

         for(int i = 1; i<arr.length; i++){
            if(arr[i] == prevEle){
                currCount++;

                if(currCount>maxCount){
                    maxCount = currCount;
                    output = arr[i];
                }
          
            }

                  else{
                    prevEle = arr[i];
                    currCount = 1;
                    
                }
         }

         return output;
    }
}