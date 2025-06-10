// LeetCode: Product of the Last K Numbers (product-of-the-last-k-numbers)
// Submission ID: 1659231188
// Language: java
// Timestamp (UTC): 2025-06-10T02:50:34Z

class ProductOfNumbers {

    static List<Integer>items;
    public ProductOfNumbers() {
        items = new ArrayList<>();
    }
    
    public void add(int num) {
        items.add(num);
    }
    
    public int getProduct(int k) {
        int output = 1;
        int lastIdx = items.size()-1;
        while(k-->0){
            output*=items.get(lastIdx);
            lastIdx--;
        }
        
        return output;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */