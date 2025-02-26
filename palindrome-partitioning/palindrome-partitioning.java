// LeetCode: Palindrome Partitioning (palindrome-partitioning)
// Submission ID: 1556380185
// Language: java
// Timestamp (UTC): 2025-02-26T18:20:22Z

class Solution {
    	public static boolean palindrome(String str) {
		if(str.length() == 1) return true;
		
		for(int i = 0; i<str.length()/2; i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
		}
		
		return true;
	}
	public static void solution(String str,List<String> output,List<List<String>>ans) {
		if(str.length() == 0) {
			System.out.println(output);
			ans.add(new ArrayList<>(output));
			return ;
		}
		
		
		for(int i = 0; i<str.length(); i++) {
			
			String firstHalf = str.substring(0, i+1);
			String rem = str.substring(i+1, str.length());
			
			if(palindrome(firstHalf)) {
				output.add(firstHalf);
				solution(rem, output,ans);
				output.remove(output.size()-1);
			}
		}
		
		
	}
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> subAns = new ArrayList<>();

        solution(s,subAns,output);

        return output;
    }
}