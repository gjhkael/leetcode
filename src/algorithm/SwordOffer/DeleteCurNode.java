package algorithm.SwordOffer;

/**
 * Created by havstack on 8/27/15.
 */
public class DeleteCurNode {


    public static void main(String[] args){
        ListNode head=new ListNode(12);
        head.next=new ListNode(13);
        ListNode cur=head;
        deleteCurNode(head,cur);
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }

    public static ListNode deleteCurNode(ListNode head,ListNode curNode){
        ListNode tmp=head;
        if(head==null||curNode==null){
            return head;
        }
        if(curNode.next==null){
            while(tmp.next!=null){
                if(tmp.next==curNode){
                    break;
                }else{
                    tmp=tmp.next;
                }
            }
            tmp.next=null;
        }else{
            curNode.value=curNode.next.value;
            curNode.next=curNode.next.next;
        }
        return head;
    }

}
class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value=value;
    }
}