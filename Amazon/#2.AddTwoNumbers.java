// 设置 dummy node 返回 dummy.next

// 设置 l1 l2 都为null 才跳出 l1 l2 val 若为null设为0 

// node若为null就不再next 设为null

// 先求出sum, next指向new node(sum取余) ,carry为该值得取十位

// 先求sum因为 carry在里面 不先存 carry 改变 会改变sum的值

// 最后判定 carry为1 加最高位1


```
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while( l1 != null || l2 != null){
            int d1 = l1 != null ? l1.val : 0;
            int d2 = l2 != null ? l2.val : 0;
            int sum = d1 + d2 + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum/10;
            l1 = l1 != null ? l1.next: null;
            l2 = l2 != null ? l2.next: null;
        }
        if(carry == 1){
           head.next = new ListNode(1); 
        }
        return dummy.next;
        
    }
```
