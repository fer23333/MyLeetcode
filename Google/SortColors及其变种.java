sort color: 0 1 2
Google : <x  x-y   >y

counting sort

分成3个部分有一次做完的方法
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
//         使用一次扫描的办法。
// 设立三根指针，left, index, right。定义如下规则：

// left 的左侧都是 0（不含 left）
// right 的右侧都是 2（不含 right）
// index 从左到右扫描每个数，如果碰到 0 就丢给 left，碰到 2 就丢给 right。碰到 1 就跳过不管。
//         000   xl   1  0 1  2    xr   222
//              left     i         right
//由于right所在位置可为任何数 而他的右侧都为2 所以交换后不能变 index 还需第二次判断
//20211210
        int left =0 ; int right = nums.length - 1;
        int index = 0;
        while(index <= right){
            if(nums[index] == 1){
                index++;
            }else if(nums[index] == 0){
                swap(nums, left++, index++);
            }else if (nums[index] == 2){
                swap(nums, right--, index);
            }
        }


Based on Comparison

A:quick sort, merge sort, bubble sort, insertion sort 给予比较的排序，最快O(nlogn)

B:counting sort, radix sort, bucket sort O(n)
