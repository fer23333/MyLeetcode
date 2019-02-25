# Missing number
0-n
Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```
1. XOR
public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;
}
2. sum
could have overflow

3. binary search (if sorted)
  
  public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        while(left < right -1){
            int mid  = left + (right - left)/2;
            if(nums[mid] > mid){
                right = mid;
            }else if(nums[mid] == mid){
                left = mid;
            }
        }
        if(left != nums[left]){
            return left;
        
        }else if(right!= nums[right]){
            return right;
        }
        //for normal situation the following integer
        return nums.length;

    }
```

# substring
对每一个string in  list use indexof or string.contains()
或者实现leetcode strStr()
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0;i <= haystack.length() - needle.length();i++){
            int j = 0;
            for(;j<needle.length();j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            if(j == needle.length()) return i;
        }
        return - 1;
    }
   
        
