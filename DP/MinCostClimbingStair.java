// dp[i]表示爬到第i层的最小cost，然后我们来想dp[i]如何推导。我们来思考一下如何才能到第i层呢？是不是只有两种可能性，
//一个是从第i-2层上直接跳上来，一个是从第i-1层上跳上来。不会再有别的方法，所以我们的dp[i]只和前两层有关系，所以可以写做如下：

// dp[i] = min(dp[i- 2] + cost[i - 2], dp[i - 1] + cost[i - 1])    
//dp数组存的是之前的cost 所以要加上cost数组 其实可以在原数组操作 并有两个变量 最快
public int minCostClimbingStairs(int[] cost) {
        //if(cost == null || cost.length == 0) return 0;
        int dp[] = new int[cost.length + 1];//the cost to climb to the top (n+1 level)
        for(int i =2; i< cost.length + 1; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
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
//     其中dp[i]表示到第i+1层的最小cost，分别初始化dp[0]和dp[1]为cost[0]和cost[1]。然后从i=2处开始遍历，
//此时我们的更新思路是，要爬当前的台阶，肯定需要加上当前的cost[i]，那么我们还是要从前一层或者前两层的台阶上跳上来，
//那么我们选择dp值小的那个，所以递归式如下：

// dp[i] = cost[i] + min(dp[i- 1], dp[i - 2])

// 最后我们在最后两个dp值中选择一个较小的返回即可

//也可以用两个变量 空间优化为O(1)
