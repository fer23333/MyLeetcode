123
456
789

//j要小于i 不然转置两遍就回到原地
矩阵的转置:
147
258
369

顺时针旋转90度 且要求 inplace:
741
852
963

所以只需要转置在移位即刻
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }    

        int row =matrix.length;
        int col =matrix[0].length;
        //matrix transpose first
        //j要小于i 不然转置两遍就回到原地
        for(int i =0; i< row; i++){
            for(int j =0; j< i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i=0; i< row; i++){
            int low =0;
            int high = col-1;
            while(low < high){
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
        
    }
