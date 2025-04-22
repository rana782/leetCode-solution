// LeetCode: Palindrome Permutation (palindrome-permutation)
// Submission ID: 1614466023
// Language: java
// Timestamp (UTC): 2025-04-22T09:41:37Z

class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length() == 1)return true;

        HashMap<Character,Integer>map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            map.put(ch,map.getOrDefault(ch,0)+1);

        }


        if(s.length()%2 == 0){

            for(int i : map.values()){
                if(i%2 == 1)return false;
            }
            return true;
        }

        else{
            int odd = 0;
            for(int i : map.values()){
                if(odd>1)return false;
                if(i%2 == 1)odd++;
            }

            return true;
        }

        
    }
}