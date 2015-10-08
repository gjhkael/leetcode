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

    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode index = helper;
        helper.next = head;
        ListNode cur = head;
        ListNode pre = head.next;
        while(pre!=null){
            while(pre!=null && pre.next!=null && pre.next.val==cur.val){
                pre=pre.next;
            }
            if(pre.val==cur.val){
                index.next = pre.next;
                cur=index.next;
                if(cur==null)
                    break;
                pre=cur.next;
            }else{
                index = cur;
                cur = pre;
                pre=cur.next;
            }
        }
        return helper.next;
    }
}
