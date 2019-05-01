

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 上下行交换
        for(int i=0; i< m/2; i++){
            for(int j=0; j< n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-1-i][j];
                matrix[m-1-i][j] = temp;
            }
        }
        //正对角线交换(左上到右下)
        for(int i=0; i< m; i++){
            for(int j= i; j< n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/

//左右交换 然后正对角线交换(左上 右下)
void anti_rotate(vector<vector<int> > &matrix) {
    for (auto vi : matrix) reverse(vi.begin(), vi.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}
