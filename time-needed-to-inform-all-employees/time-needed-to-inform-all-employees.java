// LeetCode: Time Needed to Inform All Employees (time-needed-to-inform-all-employees)
// Submission ID: 1663546382
// Language: java
// Timestamp (UTC): 2025-06-14T06:01:52Z

class Solution {
    public static class Pair{
        int sub,time;
        
        Pair(int sub,int time){
            this.sub = sub;
            this.time = time;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<Pair>>graph = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<manager.length; i++){
            if(manager[i]!=-1){
                int mngr = manager[i];
            
            graph.get(mngr).add(new Pair(i,informTime[mngr]));
            }
        }
        
        
        Queue<Pair>q = new LinkedList<>();
         int totalTime = 0;
        q.add(new Pair(headID,0));
        
        while(!q.isEmpty()){
           
          Pair p = q.poll();
            totalTime = Math.max(totalTime,p.time);
            
            int emp = p.sub;
            
            
            for(Pair nbrs : graph.get(emp)){
                
                q.add(new Pair(nbrs.sub,nbrs.time+p.time));
            }
            
         
        }
        
        return totalTime;
    }
}