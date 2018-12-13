// There is a fence with n posts, each post can be painted with one of the k colors.
// You have to paint all the posts such that no more than two adjacent fence posts have the same color.
// Return the total number of ways you can paint the fence.

// Given n=3, k=2 return 6

//       post 1,   post 2, post 3
// way1    0         0       1 
// way2    0         1       0
// way3    0         1       1
// way4    1         0       0
// way5    1         0       1
// way6    1         1       0

//DP[i]表示第i个柱子最多的选择数。在计算DP[i]时，考虑两种情况：和第i－1柱子不同颜色，
// 则可以有(k-1) * DP[i-1]个选择和第i－1柱子相同颜色，
// 此时要求i－1柱子和i－2柱子不同颜色（即第一种情况，只是换成了第i－1根柱子和第i－2根柱子不同颜色），
// 所以有(k-1) * DP[i-2]个选择因此总选择数为(k-1) * (DP[i-1] + DP[i-2])因为只和前两个柱子相关，所以可以用滚动数组来优化空间

//注意边界情况分析 n <=2时 无论k值小于等于1 都是0, k, k*k, 
               // n>2 时若k仍为1 则无法刷出指定篱笆

    public int numWays(int n, int k) {
        // write your code here
        int dp[] = {0, k , k*k, 0};
        if(n <= 2)
            return dp[n];
        if (k == 1)
            return 0;
        for(int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }

    int numWays(int n, int k) {
        if (n == 0) return 0;
        int same = 0, diff = k;
        for (int i = 2; i <= n; ++i) {
            int t = diff;
            diff = (same + diff) * (k - 1);
            same = t;
        }
        return same + diff;
    }
