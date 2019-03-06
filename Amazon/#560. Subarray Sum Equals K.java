 //prefixSum O(n2)
 public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length  == 0){
            return 0;
        }
        int count =0;
        for(int i =0; i< nums.length; i++){
            int prefixSum = 0;
            for(int j = i; j< nums.length; j++){
                prefixSum += nums[j];
                if(prefixSum == k){
                  count++;
                }
            }
        }
        return count;
    }
  // prefixSum + hashmap
 // the sums between i and j is presum[i,j] = pre_sum[j] - pre_sum[i-1]. And our goal is to make pre_sum[j] - pre_sum[i-1] = k
//存贮 出现次数 解决 0,0,0 重复数字
    public int subarraySum(int[] nums, int k) {
        int count = 0; 
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
     //初始化为0,1 解决 若有个数为k 这也是个情况
        for(int i = 0; i< nums.length; i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

