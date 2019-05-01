
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //no need to calculate length a->end and b->end
        // if a==null or b==null, a=headB, b= headA and start
        //if have intersection a+c+b  == b+c+a  if no intersection ends at null;
        if(headA == null || headB == null) return null;
        ListNode a = headA; ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;

    }
