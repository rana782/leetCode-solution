// LeetCode: Letter Combinations of a Phone Number (letter-combinations-of-a-phone-number)
// Submission ID: 1656080212
// Language: java
// Timestamp (UTC): 2025-06-06T22:46:29Z

class Solution {
    static HashMap<Character,String>map;
    
    public static List<String> solution(int idx, String digits){
        if(idx == digits.length())return new ArrayList<>();
        if(idx == digits.length()-1){
            char ch = digits.charAt(idx);
            String str = map.get(ch);
            
            List<String>subAns = new ArrayList<>();
            
            for(int i = 0; i<str.length(); i++){
                char ch1 = str.charAt(i);
                subAns.add(ch1+"");
            }
            
            return subAns;
        }
        
        
        char ch = digits.charAt(idx);
        
        String str = map.get(ch);
        
        List<String>subAns = solution(idx+1,digits);
        List<String>res = new ArrayList<>();
        
        for(int i = 0; i<str.length(); i++){
            char ch1 = str.charAt(i);
            
            for(String subStr : subAns){
                
                res.add(ch1+subStr+"");
            }
        }
        
        return res;
    }
    public List<String> letterCombinations(String digits) {
       map = new HashMap<>();
        
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        return solution(0,digits);
    }
}