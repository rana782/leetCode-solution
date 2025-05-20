// LeetCode: Data Stream as Disjoint Intervals (data-stream-as-disjoint-intervals)
// Submission ID: 1639315112
// Language: java
// Timestamp (UTC): 2025-05-20T13:17:42Z

class SummaryRanges {
    static List<Integer>nums;
    static HashSet<Integer>set;
    public SummaryRanges() {
        nums = new ArrayList<>();
        set = new HashSet<>();
    }
    
    public void addNum(int value) {
        if(!set.contains(value)){
                      nums.add(value);
                      set.add(value);
        }
      
    }
    
    public int[][] getIntervals() {
        List<List<Integer>>output = new ArrayList<>();
        int i = 0;
        Collections.sort(nums);
        while(i<nums.size()){
            int j = i;

            while(j+1<nums.size() && nums.get(j)+1 == nums.get(j+1))j++;

            output.add(Arrays.asList(nums.get(i),nums.get(j)));
            i = j+1;
        }

        int len = output.size();

        int res[][] = new int[len][2];

        int idx = 0;
        for(List<Integer>subAns : output){
            res[idx][0] = subAns.get(0);
            res[idx][1] = subAns.get(1);
            idx++;
        }

        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */