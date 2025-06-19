// LeetCode: Unique Email Addresses (unique-email-addresses)
// Submission ID: 1668891878
// Language: java
// Timestamp (UTC): 2025-06-19T03:01:53Z

class Solution {
    public static String changeLocal(String str){
        StringBuilder  output = new StringBuilder();
        
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '.')continue;
            else if(ch == '+')break;
            else{
                output.append(ch);
            }
        }
        
        return output.toString();
    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String>set = new HashSet<>();
        
              for(String str : emails){
                  StringBuilder temp = new StringBuilder();
                 String arr[] = str.split("@");
                  
                String localName = changeLocal(arr[0]);
                  
                  temp.append(localName+"@"+arr[1]);
                  
                  set.add(temp.toString());

              }

        return set.size();
    }
}