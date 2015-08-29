package algorithm.SwordOffer;

import java.util.List;

/**
 * Created by havstack on 8/28/15.
 */
public class MergeTowSortList {

    public static void main(String[] args){
        ListNode head1=new ListNode(1);
        head1.next=new ListNode(4);
        ListNode head2=new ListNode(3);
        head2.next=new ListNode(5);
        ListNode result=mergeTowSortList(head1,head2);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }

    //基本思路是不断的将最小的节点赋值给result的next节点、同时头节点指向下一个节点。
    public static ListNode mergeTowSortList(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }else if(head2==null){
            return head1;
        }
        ListNode result=null;
        if(head1.value<head2.value){
            result=head1;
            head1=head1.next;
        }else{
            result=head2;
            head2=head2.next;
        }
        ListNode tmp=result;
        while(head1!=null&&head2!=null){
            if(head1.value<head2.value){
                tmp.next=head1;
                head1=head1.next;
                tmp=tmp.next;
            }else{
                tmp.next=head2;
                head2=head2.next;
                tmp=tmp.next;
            }
        }
        if(head1!=null){
            tmp.next=head1;
        }else if(head2!=null){
            tmp.next=head2;
        }
        return result;
    }

}
