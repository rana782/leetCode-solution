class Solution {

    public static boolean check(String str, HashSet<Character>set){
        for(char ch : str.toCharArray()){
            if(set.contains(ch))return false;
        }

        return true;
    }
    public int canBeTypedWords(String text, String brokenLetters) {
      HashSet<Character>set = new HashSet<>();

      int count = 0;

      String arr[] = text.split(" ");
      for(char ch : brokenLetters.toCharArray()){
        set.add(ch);
      }

      

      for(String str : arr){
        if(check(str,set))count++;
      }

      return count;

    }
}