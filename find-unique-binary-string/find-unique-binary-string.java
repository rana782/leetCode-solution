// LeetCode: Find Unique Binary String (find-unique-binary-string)
// Submission ID: 1549877575
// Language: java
// Timestamp (UTC): 2025-02-20T17:12:52Z

class Solution {
    static boolean flag;
    public static void solution(String psf, int strLength,HashSet<String> set,List<String>output){
        if(psf.length()>strLength) return;

        if(psf.length() == strLength){
            
            if(!set.contains(psf) && flag){
                
                output.add(psf);
                flag = false;
                return;
            }

            return;
        }
if(flag){
solution(psf+"0",strLength,set,output);
}
if(flag){
solution(psf+"1",strLength,set,output);
}
        
    }
    public String findDifferentBinaryString(String[] nums) {
        if(nums.length == 1){
            if(nums[0].equals("0")) return "1";
            else{
                return "0";
            }
        }
        flag = true;
        HashSet<String>set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int strLength = nums.length;

       List<String> output = new ArrayList<>();
        solution("0",strLength,set,output);
        solution("1",strLength,set,output);

    
      return output.get(0);

    }
}