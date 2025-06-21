// LeetCode: Student Attendance Record I (student-attendance-record-i)
// Submission ID: 1671025410
// Language: java
// Timestamp (UTC): 2025-06-21T01:35:34Z

class Solution {
    public boolean checkRecord(String s) {
        
        char arr[] = s.toCharArray();
        
        int i = 0;
        int abs = 0;
        
        while(i<arr.length){
            if(arr[i] == 'P')i++;
            else if(arr[i] == 'A'){
                abs++;
                if(abs>=2)return false;
                i++;
            }
            else{
                int late = 1;
                boolean flag = false;
                while(i+1<arr.length && arr[i+1] == 'L'){
                    late++;
                    i++;
                    flag = true;
                }
                
                if(late>=3)return false;
                
                if(!flag)i++;
            }
        }
        
        return abs>=2 ? false : true;
    }
}