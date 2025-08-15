// LeetCode: Daily Temperatures (daily-temperatures)
// Submission ID: 1736207680
// Language: java
// Timestamp (UTC): 2025-08-15T14:21:30Z

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st = new Stack<>();
        int n = temperatures.length;
         int output[] = new int[n];
         int i = n-1;

         while(i>=0){
            int temp = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()]<=temp)st.pop();
            if(st.size() == 0)output[i] = 0;
            else{
                int day = st.peek()-i;
                output[i] = day;
            }
            st.push(i);

            i--;
         }

         return output;
    }
}