package algorithm.leetcode;

/**
 * Created by hy on 2015/7/27.
 *///反转链表
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pre=head;
        ListNode second=head.next;
        ListNode newNode=second.next;
        pre.next=null;
        if(newNode==null){
            second.next=pre;
            return second;
        }
        while(newNode!=null){
            second.next=pre;
            pre=second;
            second=newNode;
            newNode=newNode.next;
        }
        second.next=pre;
        return second;

        /*

        public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

        */
    }

    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode reverseHead=null;
        ListNode preNode=null;
        ListNode curNode=head;
        while(curNode!=null){
            ListNode pNext=curNode.next;
            if(pNext==null){
                reverseHead=curNode;
            }
            curNode.next=preNode;
            preNode=curNode;
            curNode=pNext;
        }
        return reverseHead;
    }
}
