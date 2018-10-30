int binarySearch(int *array, int left, int right, int value)  
{
    while (left<=right)          //循环条件，适时而变  
    {  
        int middle = left + (right-left)/2;  //使用“(left + right) / 2”可能会造成栈溢出  
        if (array[middle]>value)  
        {  
            right =middle-1;   //right赋值，适时而变  
        }   
        else if(array[middle]<value)  
        {  
            left=middle+1;  
        }  
        else  
            return middle;    
        //可能会有读者认为刚开始时就要判断相等，但毕竟数组中不相等的情况更多  
        //如果每次循环都判断一下是否相等，将耗费时间  
    }
    return -1;  
}
int binarySearch(int *array, int left, int right, int value)
{
    if (left > right) return -1;
    
    int mid = left + (left + right)/2;
    if (arrary[mid] == value) {
        return mid;
    } else if (array[mid]> value) {
        return    binarySearch(array, left, mid -1, value);
    } else if (array[mid]< value) {
        return    binarySearch(array, mid+1, right, value);
    }
    
}


//根节点应该是有序数组的中间点，从中间点分开为左右两个有序数组，在分别找出其中间点作为原中间点的左右两个子节点，二分查找法的核心思想么。
//二分法递归写法？

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return binarySearch(nums, 0, nums.length -1);
    }
    public TreeNode binarySearch(int[] nums, int l, int r){
        if(l > r) return null;
        int mid = l+ (r-l)/2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = binarySearch(nums, l, mid-1);
        cur.right = binarySearch(nums, mid+1, r);
        return cur;
    }
    //注意要 mid+1 mid-1   而且是l>r相当于上面二分法的反向
// -10 0 5
//  0  1  2
// 0 1 l<r继续 创建两个节点 

