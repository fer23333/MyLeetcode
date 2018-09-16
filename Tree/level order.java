
//BFS
//for(size) 这个循环 控制 当层循环的个数
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();       
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);        
        while(!queue.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int size = queue.size();    
            for(int i = 0; i< size; i++){
                TreeNode head = queue.poll();
                cur.add(head.val);
                if(head.left !=null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(cur);   
        }
    return result;
    } 
 ii
// Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
// (ie, from left to right, level by level from leaf to root).
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

      Collections.reverse(result);
or
        result.add(0,cur);

