// LeetCode: The Earliest Moment When Everyone Become Friends (the-earliest-moment-when-everyone-become-friends)
// Submission ID: 1611767150
// Language: java
// Timestamp (UTC): 2025-04-19T18:33:57Z

class Solution {
static int parent[];
static int rank[];


public static int find(int x){
    if(parent[x] == x)return x;

    int temp = find(parent[x]);
    parent[x] = temp;

    return temp;
}

public static boolean union(int x, int y){
    int lx = find(x);
    int ly = find(y);

    if(lx!=ly){

        if(rank[lx]>rank[ly]){
            parent[ly] = lx;
        }

        else if(rank[ly]>rank[lx]){
            parent[lx] = ly;
        }

        else{
            parent[lx] = ly;
            rank[ly]++;
        }

        return true;
    }

    return false;
}
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[0],b[0]));
        parent = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
        }

        rank = new int[n];
        Arrays.fill(rank,1);

        int mearged =0;

        for(int i = 0; i<logs.length; i++){
            int arr[] = logs[i];

            if(union(arr[1],arr[2]))mearged++;

            if(mearged == n-1)return arr[0];
        }
                return -1;
    }
}