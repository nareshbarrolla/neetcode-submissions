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
                char currentCahr = board[i][j];
                if(currentCahr == '.'){
                    continue;
                }
                if(row[i].contains(currentCahr)){
                    return false;
                }
                row[i].add(currentCahr);

                if(col[j].contains(currentCahr)){
                    return false;
                }
                col[j].add(currentCahr);   

                int boxIndex =  (i/3)*3+(j/3);
                if(box[boxIndex].contains(currentCahr)){
                    return false;
                }
                box[boxIndex].add(currentCahr);
            }
        }
        return true;
    }
    
}
