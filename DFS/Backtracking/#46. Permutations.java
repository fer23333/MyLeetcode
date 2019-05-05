//不需要startindex 因为每次需要遍历数组寻找之前没用过的元素
public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res=  new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));
        }else{
            for(int i = 0; i< nums.length; i++){
                if(temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                dfs(res, temp, nums);
                temp.remove(temp.size() -1);
            }
        }
        
    }
    
    //因为list.contains() 可能为O(n), 可以加入一个set去重
    
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res=  new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new HashSet<>());
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, Set<Integer> set){
        if(temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));
        }else{
            for(int i = 0; i< nums.length; i++){
                if(set.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                set.add(nums[i]);
                dfs(res, temp, nums, set);
                set.remove(temp.get(temp.size() -1));
                temp.remove(temp.size() -1);
                
            }
        }
        
    }
