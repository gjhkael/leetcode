package algorithm.leetcode;

/**
 * Created by kael on 2015/10/1.
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode slow=head;
        ListNode faster=head;
        while(faster!=null && faster.next!=null){
            slow = slow.next;
            faster = faster.next.next;
            if(faster == slow){
                break;
            }
        }
        if (faster == null || faster.next == null) {
            return null;
        }
        slow =head;
        while(slow!=faster){
            slow = slow.next;
            faster = faster.next;
        }
        return faster;


    }
}
