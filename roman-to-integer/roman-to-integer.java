// LeetCode: Roman to Integer (roman-to-integer)
// Submission ID: 1753185493
// Language: java
// Timestamp (UTC): 2025-08-30T06:45:47Z

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = map.get(s.charAt(s.length()-1));

        if(s.length() == 1)return map.get(s.charAt(0));

       for(int i = s.length()-2; i>=0; i--){

            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(map.get(ch1)<map.get(ch2))sum-=map.get(ch1);
            else{
                sum+=map.get(ch1);
            }
       }

        return sum;

    }
}