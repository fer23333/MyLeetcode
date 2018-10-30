    public int climbStairs(int n) {
        if(n <=1) return 1;
        if(n ==2) return 2;
        int[] dp = new int[n];
        dp[0] = 1; dp[1]= 2;
        for(int i = 2 ; i< n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
    
    //只用两个变量 O(n) O(1)
        public int climbStairs(int n) {
        if(n <=0) return 0;
        if(n ==1) return 1;
        if(n ==2) return 2;
        int a = 1; int b =2;
        int res = 0;
        for(int i =2; i< n; i++){
            res = a+b;
            a=b;
            b= res;
        }
        return res;
    }
