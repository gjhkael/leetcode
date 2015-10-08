package algorithm.leetcode;

/**
 * Created by kael on 2015/10/1.
 */
public class HasCycle {


    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}
