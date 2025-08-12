// LeetCode: Design Hit Counter (design-hit-counter)
// Submission ID: 1732463740
// Language: java
// Timestamp (UTC): 2025-08-12T13:18:50Z

class HitCounter {
    Stack<Integer>st;
    public HitCounter() {
        st = new Stack<>();
    }
    
    public void hit(int timestamp) {
        st.push(timestamp);
    }
    
    public int getHits(int timestamp) {
        int lowerLimit = timestamp-300+1;
        int count = 0;
        Stack<Integer>leftOne = new Stack<>();
        while(!st.isEmpty() && st.peek()>=lowerLimit){
            count++;
            leftOne.push(st.pop());
        }

        while(!leftOne.isEmpty()){
            st.push(leftOne.pop());
        }

        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */