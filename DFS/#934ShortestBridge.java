扫雷解法


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
                    dfs(A,i,j);
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
    public void dfs(int[][] A, int x, int y){
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


                       
dfs + bfs 

                       

    final static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0){
            return -1;
        }
        int m = A.length; 
        int n  = A[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        //dfs
        for(int i=0; i< m; i++ ){
            if(flag){
                break;
            }
            for(int j =0; j< n; j++){
                if(A[i][j] == 1){
                    dfs(A, i, j, visited, q);
                    flag = true;
                    break;
                }
            }
        }
        //bfs
        int count =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = size; i>0 ; i--){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int neix = cur[0] + dir[0];
                    int neiy = cur[1] + dir[1];
                    if(neix<0 || neiy<0 || neix>= A.length || neiy>= A[0].length || visited[neix][neiy] ){
                        continue;
                    }
                    if(A[neix][neiy] == 1){
                        return count;
                    }
                    visited[neix][neiy] = true;
                    q.offer(new int[]{neix, neiy});
                }
            }
            count++;
            
        }
        return -1;
        
    }
    
    public void dfs(int[][] A, int x, int y, boolean[][] visited, Queue<int[]> q){
        if(x<0 || y<0 || x>= A.length || y>= A[0].length || A[x][y] == 0 || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        for(int[] dir: dirs){
            dfs(A, x+dir[0], y+dir[1], visited, q);
        }
    }                       
                  
                       
                       
                       
                       
