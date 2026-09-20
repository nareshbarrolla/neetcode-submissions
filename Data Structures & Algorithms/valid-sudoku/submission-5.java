class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowTrackingMap = new int[board.length];    
        int[] colTrackingMap = new int[board.length];    
        boolean[] rowVerification = new boolean[board.length];
        boolean[] colVerification = new boolean[board.length];
        boolean[] celVerfication = new boolean[board.length];

        for(int i = 0; i < board.length; i ++){
            Arrays.fill(rowTrackingMap,0);
            Arrays.fill(colTrackingMap,0);
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    rowTrackingMap[(board[i][j]-'0')-1]++;                             
                }
                if(board[j][i] != '.'){
                    colTrackingMap[(board[j][i]-'0')-1]++;     
                }                                
            }
            boolean rowVerificationTracker = true;
            boolean colVerificationTracker = true;
            for(int j = 0; j < board.length; j++){
                if(rowTrackingMap[j]>1){
                    rowVerificationTracker = false;
                }
                if(colTrackingMap[j]>1){
                    colVerificationTracker = false;
                }
            }
            rowVerification[i] = rowVerificationTracker;
            colVerification[i] = colVerificationTracker;  
        }                

        int iValue = 0;
        int iEndCondition = 3;

        int jValue = 0;
        int jEndCondition = 3;

        int celIndex = 0;
        while(celIndex < board.length){ 
            Arrays.fill(rowTrackingMap,0);                   
            for(int i = iValue; i < iEndCondition; i++){
                for(int j = jValue; j < jEndCondition; j++){
                    // System.out.println("["+i+"]"+"["+j+"]");
                    if(board[i][j] != '.'){
                        rowTrackingMap[(board[i][j]-'0')-1]++;                        
                    }
                }    
            }
            celVerfication[celIndex] = true;
            for(int i = 0; i < board.length; i++){
                if(rowTrackingMap[i]>1){
                    celVerfication[celIndex] = false;
                    break;                        
                }
            }                                 
            jValue = jValue+3;
            jEndCondition = jEndCondition+3;
            if(jValue == 9){
                jValue = 0;
                jEndCondition = 3;
            }
            if((celIndex+1)%3 ==0){
                iValue = iValue+3;
                iEndCondition = iEndCondition+3;
            }  
            celIndex++;                                                 
        }

        boolean rowVarificationOutput = true;
        boolean colVarificationOutput = true;   
        boolean celVarificationOutput = true;   

        for(int i = 0; i < board.length; i++){
            if(rowVerification[i] == false){
                rowVarificationOutput = false;
                break;
            }
        }

        for(int i = 0; i < board.length; i++){
            if(colVerification[i] == false){
                colVarificationOutput = false;
                break;
            }
        }

        for(int i = 0; i < board.length; i++){
            if(celVerfication[i] == false){
                celVarificationOutput = false;
                break;
            }
        }

        return rowVarificationOutput && colVarificationOutput &&  celVarificationOutput;
    }
    
}
