// LeetCode: Maximum Score Words Formed by Letters (maximum-score-words-formed-by-letters)
// Submission ID: 1354164075
// Language: java
// Timestamp (UTC): 2024-08-13T10:24:38Z

class Solution {

    public static int solution(String words[], int fArr[], int score[], int idx){
        if(idx == words.length){
            return 0;
        }

        int wordNotInclude = 0+solution(words,fArr,score,idx+1);

        int naamScore = 0;
        boolean flag = true;

        String naam = words[idx];

        for(int i = 0; i<naam.length(); i++){
            char ch = naam.charAt(i);
             if(fArr[ch-'a']==0){
                flag = false;
             }
            fArr[ch-'a']--;
            naamScore+=score[ch-'a'];
        }
int wordInclude = 0;
        if(flag){
        wordInclude = naamScore+solution(words,fArr,score,idx+1);
        }

         for(int i = 0; i<naam.length(); i++){
            char ch = naam.charAt(i);
           
            fArr[ch-'a']++;
           
        }



        return Math.max(wordNotInclude,wordInclude);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] fArr = new int[26];

        for(int i = 0; i<letters.length; i++){
            char ch = letters[i];
            fArr[ch-'a']++;
        }

        return solution(words,fArr,score,0);
    }
}