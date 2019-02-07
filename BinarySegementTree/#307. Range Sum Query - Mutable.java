Segment tree is a very flexible data structure, because it is used to solve numerous range query problems like finding minimum,
maximum, sum, greatest common divisor, least common denominator in array in logarithmic time

Segment tree could be implemented using either an array or a tree. For an array implementation, if the element at index ii is not a leaf, 
its left and right child are stored at index 2i2i and 2i + 12i+1 respectively.
  
求sum父节点就是叶子节点的和 求min父节点就是叶子节点的最小值

Segment Tree can be broken down to the three following steps:

1.Pre-processing step which builds the segment tree from a given array.
2.Update the segment tree when an element is modified.
3.Calculate the Range Sum Query using the segment tree.
//使用树的方法建立 来自九章答案 代码很长
  
// 使用数组的方法建立
  
class NumArray {

    //    0-5 2-5 0-1 2-3 4-5    1 2 4 3 5 7
    //  0 1    2   3   4  5      0 1 2 3 4 5  index
    //                           6 7 8 9 10 11
    //             '22'
    //    '3'               '19'
    //  1    2        '7'        '12'      
    //              4    3     5     7
    private int[] tree;
    private int size;
    public NumArray(int[] nums) {
        if(nums.length > 0){
            size = nums.length;
            tree = new int[2*size];
            buildTree(nums);
        }
    }
    
    public void update(int i, int val) {
        i += size;
        tree[i] = val;
        while(i>0){
            //从底至上更新节点
            int left = i;
            int right = i;
            if(i % 2 ==0){
                //为偶数 更改的节点为左子树
                right = i+1;
                //那么他的右边为i+1
            }else{
                left = i-1;
            }
            tree[i/2]= tree[left] + tree[right];
            //更新父节点
            i /=2;
        }
    }
    
    public int sumRange(int i, int j) {
        i += size;
        j += size;
        int sum =0;
        //fix成i在左子树 j在右子树的结构
        while(i <= j){
            if(i % 2 != 0){
                //i不在左子树 在右子树上
                sum += tree[i];
                i++;
                //加上当前的值 并往右走一步到左子树
            }
            if(j % 2 == 0){
                //j不在右子树  在左子树上
                sum+= tree[j];
                j--;
                //走一步到右子树
            }
            i/=2;
            j/=2;
        }
        return sum;
        
    }
    
    public void buildTree(int[] nums){
        for(int i=size, j=0; i<2*size; i++,j++){
            tree[i]= nums[j];
        }
        for(int i=size-1; i>=0; i--){
            tree[i]= tree[2*i]+ tree[2*i+1];
        }
    }
    

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
