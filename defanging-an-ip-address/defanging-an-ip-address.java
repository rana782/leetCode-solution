// LeetCode: Defanging an IP Address (defanging-an-ip-address)
// Submission ID: 1654968509
// Language: java
// Timestamp (UTC): 2025-06-05T17:36:30Z

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder output = new StringBuilder();
        
        for(int i = 0; i<address.length(); i++){
            char ch = address.charAt(i);
            
            if(ch == '.'){
                output.append('[');
                output.append('.');
                output.append(']');
            }
            else{
                output.append(ch);
            }
        }
        
        System.out.println(output.toString());
        
        return output.toString();
    }
}