// LeetCode: Flatten 2D Vector (flatten-2d-vector)
// Submission ID: 1637334015
// Language: java
// Timestamp (UTC): 2025-05-18T13:47:49Z

class Vector2D {
    Queue<Integer>q;
    public Vector2D(int[][] vec) {
        q = new LinkedList<>();

        for(int d[] : vec){
            for(int ele : d){
                q.add(ele);
            }
        }
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return q.size()>0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */