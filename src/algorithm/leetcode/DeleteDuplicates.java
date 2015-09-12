package algorithm.leetcode;

/**
 * Created by hy on 2015/9/12.
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        while(second!=null){
            if(second.val != first.val){
                first = first.next;
                second = second.next;
            }else{
                second = second.next;
                first.next=second;
            }
        }
        return head;
    }
}
