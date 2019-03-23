public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node start = root;
        while(start != null){
            Node dummy = new Node(0);
            Node cur = dummy;
            while(start != null){
                if(start.left != null){
                    cur.next = start.left;
                    cur = cur.next;
                }
                if(start.right != null){
                    cur.next = start.right;
                    cur = cur.next;
                }
                start = start.next;
            }
            start = dummy.next;
        }
        return root;
    }
    
