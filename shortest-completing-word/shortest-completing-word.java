// LeetCode: Shortest Completing Word (shortest-completing-word)
// Submission ID: 1556083130
// Language: java
// Timestamp (UTC): 2025-02-26T13:12:30Z

class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
	        HashMap<Character,Integer> map1 = new HashMap<>();
	        int count = 0;
	        
	        for(int i = 0; i<licensePlate.length(); i++) {
	        	char ch = licensePlate.charAt(i);
	        	if(ch>='a' && ch<='z') {
	        		map1.put(ch, map1.getOrDefault(ch,0)+1);
	        		count++;
	        	}
	        	else if(ch>='A' && ch<='Z') {
	        		ch = Character.toLowerCase(ch);
	        		map1.put(ch,map1.getOrDefault(ch,0)+1);
	        		count++;
	        	}
	        	else {
	        		
	        	}
	        }
	        
	        String output = "";
	        int min_length = 16;
	        
	        for(String str : words) {
	        	if(str.length()>=count) {
	        		HashMap<Character,Integer>map2 = new HashMap<>(); 
	        		
	        		for(int i = 0; i<str.length(); i++) {
	        			char ch = str.charAt(i);
	        			map2.put(ch, map2.getOrDefault(ch,0)+1);
	        		}
	        		
	        		if(satisfy(map1,map2)&& str.length()<min_length) {
	        			min_length = str.length();
	        			output = str;
	        			
	        		}
	        	}
	        }
	        
	        return output.toString();
	    }

	private boolean satisfy(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
		// TODO Auto-generated method stub
		
		for(char ch : map1.keySet()) {
			 if(!map2.containsKey(ch) || map2.get(ch)<map1.get(ch)) return false;
			 
			
		}
		return true;
	}
}