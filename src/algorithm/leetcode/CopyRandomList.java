package algorithm.leetcode;

/**
 * Created by havstack on 8/18/15.
 */
public class CopyRandomList {

    public static void main(String[] args){
        RandomListNode head=new RandomListNode(-1);
        head.next=new RandomListNode(1);
        new CopyRandomList().copyRandomList(head);

    }



    public RandomListNode copyRandomList(RandomListNode head) {
        if(head ==null)
            return head;
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode tmp=new RandomListNode(cur.label);
            tmp.next=cur.next;
            cur.next=tmp;
            cur=cur.next.next;
        }

        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }


        RandomListNode result=head.next;
        RandomListNode origin=head;
        cur=result;
        while(cur.next!=null){
            origin.next=origin.next.next;
            origin=origin.next;
            cur.next=cur.next.next;
            cur=cur.next;
        }
        origin.next=null;
        return result;

    }


}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}