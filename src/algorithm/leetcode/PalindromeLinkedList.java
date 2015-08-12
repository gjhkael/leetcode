package algorithm.leetcode;

/**
 * Created by gjh on 2015/7/27.
 */
public class PalindromeLinkedList {


    //整体思路是将前半部分进行反转链表
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)  //head为空的时候竟然也返回true，真奇葩
            return true;
        int sumNode=1;
        ListNode tmp=head;
        while(tmp.next!=null){  //获得节点数
            sumNode++;
            tmp=tmp.next;
        }
        tmp=head;
        ListNode next=tmp.next;
        ListNode now=next.next;
        tmp.next=null;
        for(int i=1;i<sumNode/2;i++){
            //tmp.next=null;
            next.next=tmp;
            tmp=next;
            next=now;
            now=now.next;
        }
        head.next=next;
        if(sumNode%2==0){
            for(int i=0;i<sumNode/2;i++){
                if(tmp.val!=next.val)
                    return false;
                else{
                    tmp=tmp.next;
                    next=next.next;
                }
            }
        }else{
            for(int i=0;i<sumNode/2;i++){
                if(tmp.val!=now.val)
                    return false;
                else{
                    tmp=tmp.next;
                    now=now.next;
                }
            }

        }
        return true;
    }
}
