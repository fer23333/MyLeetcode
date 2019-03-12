    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length ==0 || grid == null) return -1;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for(int i = m-1;i>=0 ;i-- ){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 && j!= n-1){
                    dp[j] = dp[j+1] + grid[i][j];
                }else if(i != m-1 && j== n-1){
                    dp[j] = dp[j] + grid[i][j];
                }else if(i!= m-1 && j!= n-1){
                    dp[j] = Math.min(dp[j],dp[j+1]) + grid[i][j]; 
                }else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
        
    }
