// LeetCode: String Compression (string-compression)
// Submission ID: 1347698904
// Language: java
// Timestamp (UTC): 2024-08-07T12:19:27Z

class Solution {
    public int compress(char[] chars) {

        if(chars.length == 1){
            return 1;
        }
        int cnt = 1;
        StringBuilder ans = new StringBuilder();
for(int i = 0; i<chars.length-1; i++){
    if(chars[i] == chars[i+1]){
        cnt++;
        continue;
    }

    if(chars[i+1]!=chars[i]){
        if(cnt==1){
            ans.append(chars[i]);
        }
        else{
            ans.append(chars[i]);
            ans.append(cnt);
            cnt = 1;
        }
    }
}
int i = chars.length-1;
if(cnt == 1){
    ans.append(chars[i]);
}

else{
    ans.append(chars[i]);
    ans.append(cnt);
}
String str = ans.toString();
for(int j= 0; j<str.length(); j++){
    char ch = str.charAt(j);
    chars[j] = ch;
}
return ans.length();
    }
}