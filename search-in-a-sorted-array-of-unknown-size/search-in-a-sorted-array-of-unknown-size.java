// LeetCode: Search in a Sorted Array of Unknown Size (search-in-a-sorted-array-of-unknown-size)
// Submission ID: 1634156721
// Language: java
// Timestamp (UTC): 2025-05-14T23:00:23Z

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 10000;

        while(left<=right){
            int mid = left+(right-left)/2;
            int ele = reader.get(mid);

            if(ele == target)return mid;
            else if(ele == Integer.MAX_VALUE)right = mid-1;
            else if(target>ele)left = mid+1;
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}