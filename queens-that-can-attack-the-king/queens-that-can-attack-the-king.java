// LeetCode: Queens That Can Attack the King (queens-that-can-attack-the-king)
// Submission ID: 1753439946
// Language: java
// Timestamp (UTC): 2025-08-30T11:45:40Z

class Solution {
    static String kCode;
    static HashSet<String>set;
    public static boolean rowAttack(int row,int col){
     
     //leftCheck
     for(int j = col-1; j>=0; j--){
        String code = row+"_"+j;
        if(set.contains(code))break;
        if(kCode.equals(code))return true;

     }

     //rightCheck

     for(int j = col+1; j<=7; j++){
        String code = row+"_"+j;
        if(set.contains(code))break;
        if(kCode.equals(code))return true;
     }

     return false;
    }

         public static boolean colCheck(int row, int col){


            //upper

            for(int i = row-1; i>=0; i--){
                String code = i+"_"+col;
                if(set.contains(code))break;
             if(kCode.equals(code))return true;
            }

            //downSide

            for(int i = row+1; i<=7; i++){
                String code = i+"_"+col;
                if(set.contains(code))break;
             if(kCode.equals(code))return true;
            }

            return false;
         }


         public static boolean diag(int row,  int col){
            //upperDiag

            int i = row-1;
            int j = col+1;

            while(i>=0 && j<=7){
                String code = i+"_"+j;
                if(set.contains(code))break;
             if(kCode.equals(code))return true;
             i--;
             j++;

            }

            i = row+1;
            j = col+1;

            while(i<=7 && j<=7){
                String code = i+"_"+j;
                if(set.contains(code))break;
             if(kCode.equals(code))return true;
             i++;
             j++;
            }

            return false;
         }


         public static boolean antiDiag(int row, int col){
            //upper
           int i = row-1;
           int j = col-1;

           while(i>=0 && j>=0){
            String code = i+"_"+j;
                if(set.contains(code))break;
             if(kCode.equals(code))return true;
             i--;
             j--;
           }

           i = row+1;
           j = col-1;

           while(i<=7 && j>=0){
            String code = i+"_"+j;
                if(set.contains(code))break;
             if(kCode.equals(code))return true;
             i++;
             j--;
           }

           return false;

         }

         public static boolean canAttack(int row,int col){
            if(rowAttack(row, col))return true;
            if(colCheck(row, col))return true;
            if(diag(row,col))return true;
            if(antiDiag(row, col))return true;

            return false;
         }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        set = new HashSet<>();
        for(int pos[] : queens){
            String code = pos[0]+"_"+pos[1];
            set.add(code);
        }

        kCode = king[0]+"_"+king[1];

        List<List<Integer>>output = new ArrayList<>();

        for(int pos[] : queens){
            int row = pos[0];
             int col = pos[1];
             if(canAttack(row, col)){
                List<Integer>subAns = new ArrayList<>();
                subAns.add(row);
                subAns.add(col);
                output.add(subAns);
             }
        }

        return output;


    }
}