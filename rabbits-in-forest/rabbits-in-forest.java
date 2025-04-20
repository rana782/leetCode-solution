// LeetCode: Rabbits in Forest (rabbits-in-forest)
// Submission ID: 1612370178
// Language: java
// Timestamp (UTC): 2025-04-20T09:24:24Z

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map = new HashMap<>();

        int output = 0;

        for(int ele : answers){

            if(ele == 0)output++;
            else{
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
        }

        for(int ele : map.keySet()){
            int freq = map.get(ele);

            if(freq<=ele+1)output+=ele+1;
            else{
                int quo = freq/(ele+1);
                int rem = freq%(ele+1);

                output+=quo*(ele+1);

                if(rem!=0)output+=ele+1;
            }
        }

        return output;
    }
}