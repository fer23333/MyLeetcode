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

//考虑第三个护栏 或者和第一个不同 或者和第二个不同
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
