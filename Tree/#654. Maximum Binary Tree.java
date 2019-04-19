//time O(nlogn)-> O(n2)类似 quicksort
//space 
public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int left, int right){
        if(left < 0 || right > nums.length-1 || left > right){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = left;
        for(int i =left; i<= right; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode cur = new TreeNode(max);
        cur.left =  helper(nums,left, index-1);
        cur.right = helper(nums, index+1, right);
        
        return cur;
    }
//使用单调栈 time O(n)  
//We scan numbers from left to right, build the tree one node by one step;
//We use a stack to keep some (not all) tree nodes and ensure a decreasing order;
//For each number, we keep pop the stack until empty or a bigger number; 
//The bigger number (if exist, it will be still in stack) is current number's root, 
//and the last popped number (if exist) is current number's left child (temporarily, this relationship may change in the future);
//Then we push current number into the stack.


A is the biggest among nums[0] ~ nums[i - 1].
B is the biggest for the numbers between A and nums[i] (exclusive).
C is the biggest for the numbers between B and nums[i] (exclusive).
Let's use a stack, and assume that the content of the stack contains the "right path" of nodes before the node for the current number.
For the node of the new number, we should remove the nodes in the stack which are smaller than the current number.
So we pop the stack until the top element of the stack is greater than the current number.
Then, add the node for the current number to the stack.

public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }

