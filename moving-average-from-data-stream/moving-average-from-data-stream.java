// LeetCode: Moving Average from Data Stream (moving-average-from-data-stream)
// Submission ID: 1666606207
// Language: java
// Timestamp (UTC): 2025-06-17T01:33:14Z

class MovingAverage {
     static Queue<Integer>q;
    static int currSum;
    static int s;
    public MovingAverage(int size) {
        q = new LinkedList<>();
        currSum = 0;
        s = size;
        
    }
    
    public double next(int val) {
        currSum+=val;
        
        if(q.isEmpty()||q.size()<s)q.add(val);
        else{
            int removed = q.poll();
            currSum-=removed;
            q.add(val);
        }
        
        return (double)currSum/Math.min(s,q.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */