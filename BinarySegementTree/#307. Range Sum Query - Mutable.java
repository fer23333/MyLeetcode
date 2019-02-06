Segment tree is a very flexible data structure, because it is used to solve numerous range query problems like finding minimum,
maximum, sum, greatest common divisor, least common denominator in array in logarithmic time

Segment tree could be implemented using either an array or a tree. For an array implementation, if the element at index ii is not a leaf, 
its left and right child are stored at index 2i2i and 2i + 12i+1 respectively.
  
求sum父节点就是叶子节点的和 求min父节点就是叶子节点的最小值

Segment Tree can be broken down to the three following steps:

1.Pre-processing step which builds the segment tree from a given array.
2.Update the segment tree when an element is modified.
3.Calculate the Range Sum Query using the segment tree.

class SegmentTreeNode {
    SegmentTreeNode left, right;
    int sum, start, end;
    
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = null;
        this.right = null;
    }
}

class SegmentTree {
    SegmentTreeNode root;
    
    public SegmentTree(int[] nums) {
        root = build(0, nums.length - 1, nums);
    }
    
    public SegmentTreeNode build(int start, int end, int[] A) {
        // write your code here
        if(start > end) { 
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid+1, end, A);
            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum =  A[start];
            
        }
        return root;
    }
    
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        // write your code here

        if(start == root.start && root.end == end) { 
            return root.sum;
        }
        
        int mid = (root.start + root.end)/2;
        int leftsum = 0, rightsum = 0;
        
        if(start <= mid) {
            if( mid < end) { 
                leftsum =  querySegmentTree(root.left, start, mid);
            } else { 
                leftsum = querySegmentTree(root.left, start, end);
            }
        }
        
        if(mid < end) { 
            if(start <= mid) {
                rightsum = querySegmentTree(root.right, mid+1, end);
            } else {
                rightsum = querySegmentTree(root.right, start, end);
            } 
        }  
        
        return leftsum + rightsum;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modifySegmentTree(root.left, index, value);
        }
        
        if(mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        
        root.sum = root.left.sum + root.right.sum;
    }
}

class NumArray {
    SegmentTree st;

    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }
    
    public void update(int i, int val) {
        st.modifySegmentTree(st.root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return st.querySegmentTree(st.root, i, j);
    }
}
