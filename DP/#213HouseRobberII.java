   //分别让第一个和最后一个没被抢 最后比较大小 
    public int rob(int[] nums) {
        if(nums.length <=1) 
            return nums.length == 0 ? 0: nums[0];
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robMax(nums, 0, nums.length -2), robMax(nums, 1, nums.length -1));
    }
    public int robMax(int[] nums, int left, int right){
        int[] dp = new int[right+1];
        dp[left] = nums[left]; 
        dp[left+1]= Math.max(nums[left], nums[left+1]);
        if(dp.length == 2){
            return Math.max(dp[left], dp[left+1]);
        }
        for(int i = left+2; i<= right; i++ ){
            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[i]);
        }
        return dp[right];
    }
