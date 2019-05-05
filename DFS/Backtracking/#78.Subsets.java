//null, 1,1-2, 1-2-3, 1-3, 2,2-3, 3
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, int startIndex, List<Integer> temp){
        
        res.add(new ArrayList<>(temp));
        for(int i = startIndex; i< nums.length; i++){
            temp.add(nums[i]);
            dfs(res, nums, i+1, temp);
            temp.remove(temp.size() -1);
        }
    }
}
