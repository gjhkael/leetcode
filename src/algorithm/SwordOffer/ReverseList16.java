package algorithm.SwordOffer;

/**
 * Created by havstack on 8/28/15.
 */
public class ReverseList16 {


    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pReverseHead=null;
        ListNode pNode=head;
        ListNode pPre=null;
        while(pNode!=null){
            ListNode pNext=pNode.next;
            if(pNext==null)
                pReverseHead=pNode;
            pNext.next=pPre;
            pPre=pNode;
            pNode=pNext;
        }
        return pReverseHead;
    }
}
