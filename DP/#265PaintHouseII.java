// There are a row of n houses, each house can be painted with one of the k colors. 
// The cost of painting each house with a certain color is different. 
// You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x k cost matrix. 
// For example, costs[0][0] is the cost of painting house 0 with color 0; 
// costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

// Could you solve it in O(nk)?

// 设立局部变量（循环内）min和second min

    public int minCostII(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int i=0; i< k; i++){
            dp[0][i] = costs[0][i];
        }
        //当时颜色为j时 最优选择
        //设置min和secondmin 如果本身为redmin为red 就找sMin
        
        for(int i =1; i< n; i++){
            int min = Integer.MAX_VALUE; int sMin = Integer.MAX_VALUE - 1;
            for(int j = 0; j< k; j++){
                if(dp[i-1][j] < min){
                    sMin = min;
                    min = dp[i-1][j];
                }else{
                    sMin = Math.min(dp[i-1][j], sMin);
                }
            }
            for(int j = 0; j< k; j++){
                if(dp[i-1][j] == min){
                    dp[i][j] = costs[i][j]+ sMin;
                }else{
                    dp[i][j] = costs[i][j]+ min;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i =0; i< k; i++){
            result = Math.min(result, dp[n-1][i]);
            
        }
        return result;

    }
