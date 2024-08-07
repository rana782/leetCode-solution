// LeetCode: Maximum Swap (maximum-swap)
// Submission ID: 1347807591
// Language: java
// Timestamp (UTC): 2024-08-07T14:13:37Z

class Solution {

    public static void swap(char[] arr, int i, int j){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
    public int maximumSwap(int num) {
        if(num>=0 && num<=11){
            return num;
        }
      int lastIndex[] = new int[10];
      String str = Integer.toString(num);
      char[] arr = str.toCharArray();

      boolean flag = false;

      for(int i = 0 ;i<arr.length; i++){
      
        lastIndex[arr[i]-'0'] = i;
      }

      for(int i = 0; i<arr.length; i++){
        for(int j = 9; j>arr[i]-'0'; j--){
            if(lastIndex[j]>i){
                flag = true;
               
                swap(arr,lastIndex[j],i);
                break;
            }
        }
        if(flag){
            break;
        }
      }
int ans = 0;
for(int i = 0; i<arr.length; i++){
    int digit = arr[i]-'0';
    ans = ans*10+digit;
}

return ans;
    }
}
