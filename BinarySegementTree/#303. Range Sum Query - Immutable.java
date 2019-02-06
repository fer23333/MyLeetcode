Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

class NumArray {
    int[] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length+1];
        for(int i=0; i< nums.length; i++){
            prefixSum[i+1] = nums[i]+prefixSum[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0){
            return prefixSum[j+1];
        }
        return prefixSum[j+1]-prefixSum[i];
    }
}
