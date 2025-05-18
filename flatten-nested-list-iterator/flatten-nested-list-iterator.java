// LeetCode: Flatten Nested List Iterator (flatten-nested-list-iterator)
// Submission ID: 1637350164
// Language: java
// Timestamp (UTC): 2025-05-18T14:10:30Z

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    static Queue<Integer>q;
    public static void dfs(List<NestedInteger>nestedList){
        for(NestedInteger inr : nestedList){
            if(inr.isInteger())q.add(inr.getInteger());
            else{
                dfs(inr.getList());
            }
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        dfs(nestedList);
    }

    @Override
    public Integer next() {
      return  q.poll();
    }

    @Override
    public boolean hasNext() {
        return q.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */