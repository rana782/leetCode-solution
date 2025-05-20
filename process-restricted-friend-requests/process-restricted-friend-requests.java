// LeetCode: Process Restricted Friend Requests (process-restricted-friend-requests)
// Submission ID: 1639687567
// Language: java
// Timestamp (UTC): 2025-05-20T20:15:50Z

class Solution {
    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]); // Path compression
    }

    public static boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[ly] > rank[lx]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }
        return false;
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        boolean[] output = new boolean[requests.length];
        int idx = 0;

        for (int[] req : requests) {
            int p1 = req[0];
            int p2 = req[1];

            int[] parCpy = parent.clone();
            int[] rankCpy = rank.clone();

            if (find(p1) == find(p2)) {
                output[idx++] = true; // Already friends
                continue;
            }

            if (union(p1, p2)) {
                boolean isViolated = false;

                for (int[] res : restrictions) {
                    int resP1 = res[0];
                    int resP2 = res[1];

                    if (find(resP1) == find(resP2)) { // Use find, not parent[]
                        isViolated = true;
                        break;
                    }
                }

                if (isViolated) {
                    parent = parCpy;
                    rank = rankCpy;
                    output[idx++] = false;
                } else {
                    output[idx++] = true;
                }
            }
        }

        return output;
    }
}
