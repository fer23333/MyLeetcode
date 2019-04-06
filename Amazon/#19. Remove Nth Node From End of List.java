一定要有dummy node 要注意 [1,2] n=2 和 [1] n=1 的特殊情况 

public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = head;
        for(int i =0; i< n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
        
    }
