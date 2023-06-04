// LeetCode: Design File System (design-file-system)
// Submission ID: 1634930810
// Language: java
// Timestamp (UTC): 2025-05-15T18:20:43Z

class FileSystem {
    HashMap<String,Integer>map;
    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(map.containsKey(path))return false;
        int idx = path.length()-1;

        while(idx>=0 && path.charAt(idx)!='/')idx--;

        String baap = path.substring(0,idx);
        if(baap.length() == 0 || map.containsKey(baap)){
            map.put(path,value);
            return true;
        }
        
        return false;
    }
    
    public int get(String path) {
        if(map.containsKey(path))return map.get(path);
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */