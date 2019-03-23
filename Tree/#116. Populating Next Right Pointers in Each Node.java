//题目假设已经是个 perfect tree 不需要考虑 corner case
//先记录一下下一层的left节点 cur遍历到其他位置之后 需要用到这个节点
// 注意 cur.next为空 cur.right.next 直接指向空 而不是 cur.next.left

public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node cur = root;
        
        while(cur.left != null){
            Node leftMost = cur.left;
            while(cur != null){
                cur.left.next = cur.right;
                cur.right.next = cur.next != null ? cur.next.left : null;
                cur = cur.next;
            }
            cur = leftMost;
        }
        return root;
        
    }
