class Solution {
    public boolean isValidSudoku(char[][] board) {
        int boardLength = board.length;
        HashSet<Character>[] row = new HashSet[boardLength];
        HashSet<Character>[] col = new HashSet[boardLength];
        HashSet<Character>[] box = new HashSet[boardLength];
        for(int i = 0; i < boardLength; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int i = 0; i < boardLength; i++){
            for(int j = 0; j < boardLength; j++){
                char currentChar = board[i][j];
                if(currentChar == '.'){
                    continue;
                }
                if(!row[i].add(currentChar)){
                    return false;
                }               

                if(!col[j].add(currentChar)){
                    return false;
                }  

                int boxIndex =  (i/3)*3+(j/3);
                if(!box[boxIndex].add(currentChar)){
                    return false;
                }                
            }
        }
        return true;
    }
    
}
