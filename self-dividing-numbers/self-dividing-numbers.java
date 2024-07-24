// LeetCode: Self Dividing Numbers (self-dividing-numbers)
// Submission ID: 1332091889
// Language: java
// Timestamp (UTC): 2024-07-24T17:10:41Z

class Solution {
    public static boolean check(int num){
        int original = num;

        while(num!=0){
            int rem = num%10;

            if(rem == 0){
                return false;
            }

            else if(original%rem!=0){
                return false;
            }
            num = num/10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        while(left<=right){
            int num = left;
            if(num<=9){
                ans.add(num);
                left++;
                continue;
            }

            if(check(num)){
                ans.add(num);
            }
            left++;
        }

        return ans;
        
        
            }
}