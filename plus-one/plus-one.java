// LeetCode: Plus One (plus-one)
// Submission ID: 1663751066
// Language: java
// Timestamp (UTC): 2025-06-14T10:25:36Z

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer>output = new ArrayList<>();
         int idx = digits.length-1;
        
        int carry = 1;
        while(idx>=0 || carry!=0){
            int sum = 0;
            
            if(idx>=0){
                sum+=digits[idx];
            }
            
            sum+=carry;
            
            int rem = sum%10;
            output.add(rem);
            carry = sum/10;
            idx--;
        }
        
        
        Collections.reverse(output);
        
        int res[] = new int[output.size()];
        
        for(int i = 0; i<res.length; i++){
            res[i] = output.get(i);
        }
        
        return res;
    }
}