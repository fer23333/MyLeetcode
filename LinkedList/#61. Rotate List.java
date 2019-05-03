public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode cur = head;
        int length = 1;
        while(cur.next != null){
            cur = cur.next;
            length++;
        }
        cur.next = head;
        k = length- (k % length);
        for(int i=0 ;i < k; i++){
            cur = cur.next;
            head = head.next;
        }
        cur.next = null;
        return head;
        
    }
