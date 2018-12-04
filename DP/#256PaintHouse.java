// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
//   The cost of painting each house with a certain color is different. 
//   You have to paint all the houses such that no two adjacent houses have the same color.
// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
// For example, costs[0][0] is the cost of painting house 0 with color red; 
// costs[1][2] is the cost of painting house 1 with color green, and so on... 
// Find the minimum cost to paint all houses.
//这道题说有n个房子，每个房子可以用红绿蓝三种颜色刷，每个房子的用每种颜色刷的花费都不同，
//限制条件是相邻的房子不能用相同的颜色来刷，现在让我们求刷完所有的房子的最低花费是多少

    public int minCost(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0]; dp[0][1] = costs[0][1]; dp[0][2] = costs[0][2];
        //当时颜色为j时 最优选择
        for(int i =1; i< n; i++){
            dp[i][0]= Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1]= Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2]= Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }
        int min = Math.min(dp[n-1][0], dp[n-1][1]);
        return Math.min(dp[n-1][2], min);
    }


