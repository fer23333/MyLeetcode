# Two sum 及其变种

# 判定 1.数组是否存在重复元素 2.pair是否可以重复(1,2) (2,1) 3.数组是否sort  4.输入输出需要什么 5. (2,2)-4和(2)-4 的情况 

## 1.Two sum

return index and exactly one solution

### HashMap

O(n) O(n)
```
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length < 2){
            return new int[]{0};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i =0; i< numbers.length; i++){
            if(!map.containsKey(target - numbers[i]) ){
                map.put(numbers[i], i);
            }else{
                res[0] = map.get(target - numbers[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
```
### sort and binary search

需要保存sort前的index 如果需要节省空间复杂度 要借用辅助类


## 2.Two sum input is sorted

### Two Pointer

双指针从首尾往中间靠 找到和为target的元素 返回他们的index
```
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        int left = 0;
        int right = nums.length -1;
        int[] res = new int[2];
        while(left < right){
            int sum = nums[left] +nums[right];
            if(sum == target){
               res[0] = left+1;
               res[1] = right+1;
               break;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
        
    }
```

## 3.Two Sum III - Data structure design

### HashMap

add 和find操作 如果存在pair的sum == target return true

不能使用 hashset 因为add(2) find(4) 其实只有一个2

### 此题可以有重复的pair answer 而且可以add(2) add(2) find(4), 小心 add(2) find(4)

设置一个hashmap 记录频率 如果差值和key相同 判定 频率是否大于1


```
    private Map<Integer, Integer> map = new HashMap<>();
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(int key : map.keySet()){
            if(map.containsKey(value - key)){
                if(key == value - key){
                    return map.get(key) > 1;
                }
                return true;
            }
        }
        return false;
    }
```

## 4. Two sum Iv input is BST

如果只是return true

1. 设一个set
2. inorder存到array里(sorted) 再用two pointer
3. 纯 递归dfs


return result array
1. HashSet
```
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if(root == null){
            return null;
        }
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        helper(root, n, set, res);
        return res;
    }
    public void helper(TreeNode root, int n , Set<Integer> set, int[] res){
        if(root == null){
            return ;  
        }
        helper(root.left, n, set, res);
        if(set.contains(n - root.val)){
            res[0] = root.val;
            res[1] = n - root.val;
            return;
        }else{
            set.add(root.val);
        }
        helper(root.right, n , set, res); 
    }
```

2. iterative using BFS and BST

3. BST inorder + two pointers

## 5. two sum unique pairs

### 如果只返回 count

1 1 2 2 11 11 要求滤掉相同的pair  但是pair里元素可以重复 11,11 ->22

排序之后 双指针 然后如果有重复pair则跳过 这样节省空间和时间 不用后面再去重
```
while(left< right && nums[left] == nums[left-1]) 1 1 2 2
//必须相隔一位 
```
O(nlogn) O(1)
```
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length  == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count  = 0;
        while(left < right){
            if(nums[left] + nums[right] == target){
                count++;
                left++;
                right--;
                while(left< right && nums[left] == nums[left-1]){
                    left++;
                }
                while(right> left && nums[right] == nums[right+1]){
                    right--;
                }
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
```

### 返回所有的 pairs, pair内部元素可重复 两个HashSet
1 2 2 3 4 5-4 ,  1 2 3 4 5 -4
```
    public static List<List<Integer>> twoSum6(int[] nums, int target) {
        // write your code here
        if(nums == null|| nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer>  dic = new HashSet<>();
        Set<Integer> matched =  new HashSet<>();
        for(int i =0; i< nums.length; i++){
            if(!matched.contains(nums[i]) && dic.contains(target - nums[i])){
                List<Integer> list = new ArrayList<>();
                matched.add(nums[i]);
                matched.add(target - nums[i]);
                list.add(nums[i]);
                list.add(target - nums[i]);
                result.add(list);
            }
                dic.add(nums[i]);
            
        }
        return result;
    }
```
## 6. two sum greater-than-target 

排序之后 相向双指针 

```
Input: [1, 1, 1, 1], target = 1
Output: 6
//Do it in O(1) extra space and O(nlogn) time.
```
```
   public int twoSum2(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length ==0){
            return 0;
        }
        Arrays.sort(nums);
        int i = 0; 
        int j = nums.length -1;
        int count =0;
        while(i<j){
            if(nums[i]+nums[j] > target){
                count += j-i;
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
```

## 7 Two Sum - Difference equals to target
Given an array of integers, find two numbers that their difference equals to a target value.

where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

It's guaranteed there is only one available solution

要求输出结果要排好序 然后当前的index所在value不会存进map 

```
   public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length <2){
            return new int[2];
        }
        int[] res= new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length; i++){
            if(map.containsKey(target + nums[i])){
                res[0] =  map.get(target +nums[i]);
                res[1] =  i+1;
                break;
            }
            if(map.containsKey(nums[i]- target)){
                res[0] = map.get(nums[i]- target);
                res[1] = i+1;
                break;
            }
            map.put(nums[i], i+1);
        }
        return res;
    }
```

## 8 Two Sum - Closest to target
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

也有可能return 这两个 integer


    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2){
            return -1;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int left =0;
        int right = nums.length -1;
        while(left < right){
            int curSum = nums[left] + nums[right];
            if(curSum == target){
                return 0;
            }else if(curSum > target){
                diff = Math.min(diff, curSum - target);
                right--;
                
            }else{
                diff = Math.min(diff, target - curSum);
                left++;
            }
            
        }
        return diff;
    }

# 9 Triangle count 
两边之和大于第三边 

k >j > i => a[j] + a[k] > a[i]
```
O(n3)
i 0->n
 j 0->i
  k 0->j
   if(a[j] + a[k] > target)
    count++
```

```
O(n2)
利用 第#6 题
    public int triangleCount(int[] S) {
        // write your code here
        if(S == null || S.length < 3){
            return 0;
        }
        Arrays.sort(S);
        int n = S.length -1;
        int count = 0;
        for(int i = n; i>=2 ; i--){
            int left = 0; 
            int right = i-1;
            while(left < right){
                if(S[left] + S[right] > S[i]){
                    count += right - left;
                    right--;
                }else{

                    left++;
                }
            }
        }
        return count;
    }
```            

# 10 3 Sum

```
O(n2)

```
