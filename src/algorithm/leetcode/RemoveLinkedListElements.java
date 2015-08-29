package algorithm.leetcode;

/**
 * Created by hy on 2015/7/27.
 */
public class RemoveLinkedListElements{

    public static void main(String []args){
        ListNode test=new ListNode(1);
        test.next=new ListNode(2);
        deleteNode(test.next);
        //test.next.next=new ListNode(2);
       // test.next.next.next=new ListNode(1);
       // ListNode head=removeElements(test,1);
        while(test!=null) {
            System.out.println(test.val);
            test=test.next;
        }

    }

    public static void deleteNode(ListNode node) {
        if(node.next==null){
            node=null;
            return;
        }
        ListNode tmp=node.next;
        if(tmp.next!=null){
            node.val=tmp.val;
            node.next=tmp.next;
        }else{
            node.val=tmp.val;
            node.next=null;
        }
    }

    public static  ListNode removeElements(ListNode head, int val) {  //
        if(head==null)
             return null;
        /*ListNode tmp=head;
        while(tmp.next!=null){
            if(tmp.next.val==val){
                tmp.next=tmp.next.next;
            }else{
                tmp=tmp.next;
            }
        }
        return head.val==val?head.next:head;*/

        ListNode tmp=head;   //如果把tmp指向的引用赋值为null是无效的，只能通过改变他指向引用的next引用来改变链表。
        tmp.next=null;
        return head;
    }
}
