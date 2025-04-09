// LeetCode: Longest Happy String (longest-happy-string)
// Submission ID: 1602092693
// Language: java
// Timestamp (UTC): 2025-04-09T20:53:31Z

class Solution {
public class Pair implements Comparable<Pair>{
    char ch;
    int freq;

    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Pair o){
        return this.freq - o.freq;
    }
}

public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

    if (a > 0) pq.add(new Pair('a', a));
    if (b > 0) pq.add(new Pair('b', b));
    if (c > 0) pq.add(new Pair('c', c));

    StringBuilder res = new StringBuilder();

    while (!pq.isEmpty()) {
        Pair curr = pq.poll();

        int len = res.length();
        // Check last two chars
        if (len >= 2 && res.charAt(len - 1) == curr.ch && res.charAt(len - 2) == curr.ch) {
            // Can't use curr now, try next most frequent
            if (pq.isEmpty()) break; // No valid choice left

            Pair next = pq.poll();

            res.append(next.ch);
            next.freq--;

            if (next.freq > 0) pq.add(next);
            pq.add(curr); // Put curr back
        } else {
            res.append(curr.ch);
            curr.freq--;

            if (curr.freq > 0) pq.add(curr);
        }
    }

    return res.toString();
}
}