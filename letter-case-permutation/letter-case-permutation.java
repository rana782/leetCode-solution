// LeetCode: Letter Case Permutation (letter-case-permutation)
// Submission ID: 1348626898
// Language: java
// Timestamp (UTC): 2024-08-08T07:53:35Z

class Solution {
    	public static List<String>getCombination(String str){
		if(str.length() == 0) {
			List<String> bAns = new ArrayList<>();
			bAns.add("");
			return bAns;
		}
		char ch = str.charAt(0);
		boolean digit = Character.isDigit(ch);
		boolean lower = Character.isLowerCase(ch);
		boolean upper = Character.isUpperCase(ch);
		String rem = str.substring(1);
		List<String> rAns = getCombination(rem);
		List<String> output =  new ArrayList<>();
		
		if(digit) {
			for(String subAns:rAns) {
				output.add(ch+subAns);
			}
		}
		
		if(lower) {
			for(String subAns:rAns) {
				output.add(ch+subAns);
				output.add(Character.toUpperCase(ch)+subAns);
			}
		}
		
		if(upper) {
			for(String subAns:rAns) {
				output.add(ch+subAns);
				output.add(Character.toLowerCase(ch)+subAns);
			}
		}
		
		return output;

		
	}
    public List<String> letterCasePermutation(String s) {
        List<String>ans = getCombination(s);
        return ans;
    }
}