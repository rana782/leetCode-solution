// LeetCode: Zigzag Iterator (zigzag-iterator)
// Submission ID: 1634911043
// Language: java
// Timestamp (UTC): 2025-05-15T17:59:09Z

public class ZigzagIterator {
Queue<Integer>q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        int s1 = v1.size();
        int s2 = v2.size();
        int it1 = 0, it2 = 0;

        while(it1<s1 || it2<s2){
            if(it1<s1){
                q.add(v1.get(it1));
                it1++;
            }

            if(it2<s2){
                q.add(v2.get(it2));
                it2++;
            }

        }

    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return q.size() != 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */