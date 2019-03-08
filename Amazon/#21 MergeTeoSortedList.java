 //设置 dummy node 然后往两个node比较小的val 链接
 // 注意 1-3-4 5 , 1-3-4 2这些情况 会有一个node先为null
 
 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur= dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next= l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;    
        }else{
            cur.next = l1;
        }
        return dummy.next;
    }
