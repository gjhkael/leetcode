package algorithm.leetcode;

/**
 * Created by hy on 2015/9/30.
 */
public class InsertionSortList {
    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        ListNode result = insertionSortList(head);
        System.out.println(result.val);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null||head.next ==null){
            return head;
        }

        ListNode helper=new ListNode(0);
        ListNode pre=helper;
        ListNode current=head;
        while(current!=null) {
            pre=helper;
            while(pre.next!=null&&pre.next.val<current.val) {
                pre=pre.next;
            }
            ListNode next=current.next;
            current.next=pre.next;
            pre.next=current;
            current=next;
        }
        return helper.next;

    }
}
