// LeetCode: Parallel Courses (parallel-courses)
// Submission ID: 1753156516
// Language: java
// Timestamp (UTC): 2025-08-30T06:17:43Z

import java.util.*;

class Solution {

    // DFS helper to detect a cycle in a directed graph (1-based indices)
    public static boolean cyclic(int vertex, boolean[] visited, boolean[] inPath, ArrayList<ArrayList<Integer>> graph) {
        visited[vertex] = true;
        inPath[vertex] = true;

        for (int nbr : graph.get(vertex)) {
            if (!visited[nbr]) {
                if (cyclic(nbr, visited, inPath, graph)) return true;
            } else if (inPath[nbr]) {
                return true; // back edge -> cycle
            }
        }

        inPath[vertex] = false;
        return false;
    }

    public int minimumSemesters(int n, int[][] relations) {
        // Build adjacency list for 1..n
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        int[] indeg = new int[n + 1];

        for (int[] e : relations) {
            int src = e[0];
            int dest = e[1];
            graph.get(src).add(dest);
            indeg[dest]++; // needed for Kahn BFS
        }

        // 1) Cycle check via DFS (optional; Kahn also detects cycle but DFS matches your helper)
        boolean[] visited = new boolean[n + 1];
        boolean[] inPath = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (cyclic(i, visited, inPath, graph)) return -1;
            }
        }

        // 2) Kahn's Algorithm (BFS by levels) to count semesters
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int semesters = 0;
        int processed = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            semesters++; // all in current queue can be taken this semester

            for (int k = 0; k < sz; k++) {
                int u = q.poll();
                processed++;
                for (int v : graph.get(u)) {
                    if (--indeg[v] == 0) q.offer(v);
                }
            }
        }

        return processed == n ? semesters : -1; // if not all processed, cycle exists
    }
}
