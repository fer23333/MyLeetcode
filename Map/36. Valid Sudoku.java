public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                char num = board[i][j];
                if(num == '.'){
                    continue;
                }
                if(!seen.add(num + "in row" + i) || 
                   !seen.add(num + "in col" + j) ||
                   !seen.add(num + "in cube" + i/3 + " "+ j/3)
                  
                  ){
                    return false;
                }
            }
        }
        return true;
    }
