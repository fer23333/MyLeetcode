    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i = 2; i< n+1; i++){
            dp[i] = Math.min(dp[i-1] +cost[i-1] , dp[i-2] +cost[i-2]); 
        }
        return dp[n];
    }
    
    
      public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0)
            return 0;
        int[] costArray = new int[cost.length+1];
        costArray[1]=cost[0];
        for(int i=2;i<=cost.length;i++) {
            costArray[i] = cost[i-1] + Math.min(costArray[i-2], costArray[i-1]);
        }
        return Math.min(costArray[costArray.length-1],costArray[costArray.length-2]);
    }
    其中dp[i]表示到第i+1层的最小cost，分别初始化dp[0]和dp[1]为cost[0]和cost[1]。然后从i=2处开始遍历，此时我们的更新思路是，要爬当前的台阶，肯定需要加上当前的cost[i]，那么我们还是要从前一层或者前两层的台阶上跳上来，那么我们选择dp值小的那个，所以递归式如下：

dp[i] = cost[i] + min(dp[i- 1], dp[i - 2])

最后我们在最后两个dp值中选择一个较小的返回即可
