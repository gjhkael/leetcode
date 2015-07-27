package leetcode;

/**
 * Created by hy on 2015/7/27.
 */
public class DeleteNode{

    public void deleteNode(ListNode node) {
        if(node.next==null){
            node=null;
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
}
