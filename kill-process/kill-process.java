// LeetCode: Kill Process (kill-process)
// Submission ID: 1611787768
// Language: java
// Timestamp (UTC): 2025-04-19T19:00:12Z

class Solution {

    static List<Integer>output;
    public static void dfs(int vertex,  HashMap<Integer,List<Integer>>map){
        output.add(vertex);

       

      List<Integer> list = map.get(vertex);
      if (list != null) {
         for (int nbrs : list) {
                 dfs(nbrs, map);
    }
}

    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();

        for(int i = 0; i<ppid.size(); i++){
            if(ppid.get(i)!=0){
                int child = pid.get(i);
                int parent = ppid.get(i);

               List<Integer>list = map.getOrDefault(parent,new ArrayList<>());
               list.add(child);
               map.put(parent,list);
            }
        }
            output = new ArrayList<>();

        dfs(kill,map);

        return output;


    }
}