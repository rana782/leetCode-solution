// LeetCode: Number of Lines To Write String (number-of-lines-to-write-string)
// Submission ID: 1756568624
// Language: java
// Timestamp (UTC): 2025-09-02T04:07:08Z

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int output[] = new  int[2];
        int count = 0;
         int prev = 0;
        int pixCount = 0;

        for(int i = 0; i<s.length(); i++){
             char ch = s.charAt(i);
            int currPix = widths[ch-'a'];
            if(pixCount+currPix>100){
                pixCount = currPix;
                prev = pixCount;
                count++;
            }else{
                pixCount+=currPix;
                prev = pixCount;
            }
        }

        output[0] = count+1;
        output[1] = prev;

        return output;
    }
}