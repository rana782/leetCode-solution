// LeetCode: K-th Symbol in Grammar (k-th-symbol-in-grammar)
// Submission ID: 1638312817
// Language: java
// Timestamp (UTC): 2025-05-19T14:00:00Z

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid) {
            return kthGrammar(n - 1, k);           // same as parent
        } else {
            return 1 - kthGrammar(n - 1, k - mid); // flipped from parent
        }
    }
}
