//如果第一行 或者 第一列有0 就都会为0 先用flag记录下来
// 如果 matrix[i][j] == 0 就将 matrix[i][0]和matrix[0][j] 都为0, 下次如果在该行 或者该列 就将这个值设为0


public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i =0 ;i< row; i++){
            for(int j=0; j< col; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        firstRow = true;
                    }
                    if(j == 0){
                        firstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i= 1; i< row; i++){
            for(int j=1; j< col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow){
            for(int j=0; j< col; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstCol){
            for(int i=0; i< row; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
