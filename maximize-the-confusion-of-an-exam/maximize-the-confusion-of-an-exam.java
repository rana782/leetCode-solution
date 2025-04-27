// LeetCode: Maximize the Confusion of an Exam (maximize-the-confusion-of-an-exam)
// Submission ID: 1619321078
// Language: java
// Timestamp (UTC): 2025-04-27T12:41:17Z

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        //changing F's into T atmost k times

        int output1 = 0;

        int j = 0;
        int count = 0;

        for(int i = 0; i<answerKey.length(); i++){
                if(answerKey.charAt(i) == 'F')count++;

                while(j<=i && count>k){
                    if(answerKey.charAt(j) == 'F')count--;
                    j++;
                }

                int len = i-j+1;
                output1 = Math.max(len,output1);
        }

        int output2 = 0;
        count = 0;
        j = 0;

                for(int i = 0; i<answerKey.length(); i++){
                if(answerKey.charAt(i) == 'T')count++;

                while(j<=i && count>k){
                    if(answerKey.charAt(j) == 'T')count--;
                    j++;
                }

                int len = i-j+1;
                output2 = Math.max(len,output2);
        }

        return Math.max(output1,output2);
    }
}