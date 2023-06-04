// LeetCode: Logger Rate Limiter (logger-rate-limiter)
// Submission ID: 1634145458
// Language: java
// Timestamp (UTC): 2025-05-14T22:29:59Z

class Logger {
    HashMap<String,Integer>map;
    public Logger() {
       map = new HashMap<>(); 
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){

            if(map.get(message)<=timestamp){
                map.put(message,timestamp+10);
                return true;
            }

            return false;
        }

        else{
            map.put(message,timestamp+10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */