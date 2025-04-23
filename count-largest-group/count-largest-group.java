// LeetCode: Count Largest Group (count-largest-group)
// Submission ID: 1615607793
// Language: java
// Timestamp (UTC): 2025-04-23T11:42:01Z

class Solution {
    public static int getSum(int n){
        if(n<10)return n;

        int output = 0;

        while(n!=0){
            int rem = n%10;
            output+=rem;
            n/=10;
        }

        return output;
    }
    public int countLargestGroup(int n) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        int maxSize = 0;

        for(int i = 1; i<=n; i++){
            int digitSum = getSum(i);

            map.put(digitSum,map.getOrDefault(digitSum,0)+1);
            maxSize = Math.max(maxSize,map.get(digitSum));
        }

        int output = 0;

        for(int ele : map.values()){
            if(ele == maxSize)output++;
        }

        return output;
    }
}