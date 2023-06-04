// LeetCode: Lexicographical Numbers (lexicographical-numbers)
// Submission ID: 1354070653
// Language: java
// Timestamp (UTC): 2024-08-13T08:24:03Z

class Solution {

    public static void solution(int i, int n,List<Integer> current){
        if(i>n){
            return;
        }
        current.add(i);
        for(int j = 0; j<=9; j++){
            solution(10*i+j,n,current);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer>current = new ArrayList<>();

        for(int i = 1; i<=9; i++){
            solution(i,n,current);
        }

        return current;
    }
}