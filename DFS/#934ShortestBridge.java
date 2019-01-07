扫雷解法

```java
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};    
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0){
            return 0; 
        }
        int m = A.length;
        int n = A[0].length;
        
        boolean breakFlag = false;
        //set a flag to break from outter loop
        //when you finish seraching the first island      
        for(int i=0; i<m; i++ ){
            if(breakFlag){
                break;
            }
            for(int j =0; j< n; j++){
                if(A[i][j] == 1){
                    dfs(A,i,j,dirs);
                    breakFlag = true;
                    break;
                }
            }   
        }
        for(int color =2; ; color++){
            for(int i =0; i< m; i++){
                for(int j =0; j<n; j++){
                    if(A[i][j] == color && ( 
                        //searching around by 4 directions 
                        for(int[] dir :dirs){
                            expand(A, i+dir[0], j+dir[1], dirs, color);
                        }
                      ){
                        return color -2;
                    }
                }
            }
        }
    
    }
    public void dfs(int[][] A, int x, int y, int[][] dirs){
        if(x >= A.length || x < 0 || y < 0 || y >= A[0].length || A[x][y] == 0 || A[x][y] == 2){
            return;
        }
        A[x][y] = 2;
        for(int[] dir :dirs){
            dfs(A, x+dir[0], y+dir[1], dirs);
        }
    }
    public boolean expand(int[][] A, int x, int y, int[][] dirs, int color){
        //looking for 0 and set color+1
        //if another island found, return true;
        if(x >= A.length || x < 0 || y < 0 || y >= A[0].length){
            return false;
        }
        if(A[x][y] == 0){
            A[x][y] = color + 1;
        }
        return A[x][y] == 1;
    }

```
