// LeetCode: Course Schedule II (course-schedule-ii)
// Submission ID: 1636556659
// Language: java
// Timestamp (UTC): 2025-05-17T16:44:23Z

class Solution {
    public static void dfs(int vertex, List<List<Integer>>graph,boolean visited[], Stack<Integer>st){
        visited[vertex] = true;
        for(int nbrs : graph.get(vertex)){
            if(!visited[nbrs]){
                dfs(nbrs,graph,visited,st);
            }
        }
        st.push(vertex);
    }

    public static boolean cycleExist(int vertex,List<List<Integer>>graph, boolean visited[], boolean path[]){
        if(path[vertex])return true;
        if(visited[vertex])return false;

        path[vertex] = true;
        visited[vertex] = true;

        for(int nbrs : graph.get(vertex)){
            if(cycleExist(nbrs,graph,visited,path))return true;
        }
        path[vertex] = false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            int arr[] = new int[numCourses];
            for(int i = 0; i<numCourses; i++){
                arr[i] = i;
            }
            return arr;
        }

        List<List<Integer>>graph = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int e[] : prerequisites){
            int a = e[0];
            int b = e[1];
            graph.get(b).add(a);
        }

        boolean visited[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(cycleExist(i,graph,visited,path)){
                int arr[] = new int[0];
                return arr;
            }
        }

        visited= new boolean[numCourses];
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i<numCourses; i++){
            if(visited[i] == false){
                dfs(i,graph,visited,st);
            }
        }

        int output[] = new int[numCourses];
        int idx = 0;
        while(st.size()!=0){
            output[idx++] = st.pop();
        }

        return output;


    }
}