//O(n)的解法，定义两个变量res和curSum，其中res保存最终要返回的结果，即最大的子数组之和，curSum初始值为0，
//每遍历一个数字num，比较curSum + num和num中的较大值存入curSum，
//然后再把res和curSum中的较大值存入res，以此类推直到遍历完整个数组，可得到最大子数组的值存在res中
//-1 2 3 -2 1
//比较curSum  之前数之和 +当前数 和 当前数 比较大小 
// maxsum 会出现在 加上前面半段 或者 从自己半段开始的这些区间里
public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }      
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i =0; i< nums.length; i++){
            curSum = Math.max(nums[i]+ curSum, nums[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }
    
//kadane algorithm 因为第一个数可能为负数 所以需要initialize 都为第一个数 然后从1 开始
public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }      
        int curMax = nums[0];
        int allMax = nums[0];
        for(int i =1; i< nums.length; i++){
            curMax = Math.max(nums[i]+ curSum, nums[i]);
            allMax = Math.max(res, curSum);
        }
        return res;
    }
    
    //O(nlogn) divide & conquer
    //类似于二分搜索法，我们需要把数组一分为二，分别找出左边和右边的最大子数组之和，
    //然后还要从中间开始向左右分别扫描，求出的最大值分别和左右两边得出的最大值相比较取最大的那一个
        public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
