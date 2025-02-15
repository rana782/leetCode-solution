// LeetCode: Find the Punishment Number of an Integer (find-the-punishment-number-of-an-integer)
// Submission ID: 1543695541
// Language: java
// Timestamp (UTC): 2025-02-15T09:21:25Z

class Solution {
    static boolean flag;
	public static void fxn(String str, int currSum,int num) {
		if(str.isEmpty() && currSum == num) {
			
			System.out.println(currSum);
            flag = true;
			return;
		}
		
		int idx = 0;
		
		while(idx<str.length()) {
			String firstStr = str.substring(0,idx+1);
			int numValue = Integer.parseInt(firstStr);
			
			String restStr = str.substring(idx+1);
			fxn(restStr, currSum+numValue, num);
			idx++;
		}
		
		
	}
    public int punishmentNumber(int n) {
        int sum = 0;

        for(int i = 1; i<=n; i++){

            flag = false;
            int product = i*i;
            fxn(String.valueOf(product),0,i);
            if(flag)sum+=product;
        }

        return sum;
    }
}