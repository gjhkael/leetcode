package algorithm.leetcode;

/**
 * Created by kael on 2015/10/2.
 */
public class SwapPairs {


    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next==null){
            return head;
        }
        ListNode helper = new ListNode(0);
        helper.next=head;
        ListNode index= helper;
        ListNode cur = head;
        ListNode pre = head.next;
        while(cur!=null&&pre!=null){
            cur.next=pre.next;
            index.next=pre;
            pre.next=cur;
            index=cur;
            cur = cur.next;
            if(cur==null){
                break;
            }
            pre=cur.next;
        }
        return helper.next;
    }
}
