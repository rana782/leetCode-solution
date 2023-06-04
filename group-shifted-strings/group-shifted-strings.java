// LeetCode: Group Shifted Strings (group-shifted-strings)
// Submission ID: 1634870856
// Language: java
// Timestamp (UTC): 2025-05-15T17:17:29Z

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>>output = new ArrayList<>();
        List<String>single = new ArrayList<>();

        HashMap<String,List<String>>map = new HashMap<>();

        for(String str : strings){
            if(str.length() == 1)single.add(str);
            else{
                StringBuilder code = new StringBuilder();

                for(int i = 0; i<str.length()-1; i++){
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(i+1);

                    int diff = ch1-ch2;
                    if(diff<0)diff+=26;
                    code.append(diff);
                    code.append("_");
                }

                List<String>subAns = map.getOrDefault(code.toString(),new ArrayList<>());
                subAns.add(str);
                map.put(code.toString(),subAns);
            }
        }

        for(List<String>l :map.values()){
            output.add(l);
        }
        if(single.size()!=0)output.add(single);

        return output;
    }
}