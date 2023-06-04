// LeetCode: Rotate Array (rotate-array)
// Submission ID: 1637238666
// Language: java
// Timestamp (UTC): 2025-05-18T11:22:04Z

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int rotation = k%n;

        if(rotation == 0)return;


        Deque<Integer>dq = new ArrayDeque<>();
        for(int i = 0; i<nums.length; i++){
            dq.addLast(nums[i]);
        }
        while(rotation-->0){
            int ele = dq.removeLast();
            dq.addFirst(ele);
        }

        for(int i = 0; i<nums.length; i++){
            nums[i] = dq.removeFirst();
        }

    }
}