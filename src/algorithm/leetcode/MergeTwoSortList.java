package algorithm.leetcode;

/**
 * Created by hy on 2015/9/12.
 */
public class MergeTwoSortList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head;
        if(l1.val<l2.val){
            head = l1;
            l1=l1.next;
        }else{
            head = l2;
            l2=l2.next;
        }
        ListNode tmp = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tmp.next = l1;
                l1=l1.next;
                tmp=tmp.next;
            }else{
                tmp.next = l2;
                l2=l2.next;
                tmp=tmp.next;
            }
        }
        if(l1!=null){
            tmp.next = l1;
        }
        if(l2!=null){
            tmp.next = l2;
        }
        return head;

    }
}
