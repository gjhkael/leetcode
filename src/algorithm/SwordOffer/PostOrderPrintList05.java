package algorithm.SwordOffer;

/**
 * Created by havstack on 8/21/15.
 */
public class PostOrderPrintList05 {

    public static void main(String[] args){
        Node head=new Node(12);
        head.next=new Node(13);
        head.next.next=new Node(14);
        postOrderPrintList(head);

    }

    public static void postOrderPrintList(Node head){
        if(head==null)
            return ;
        postOrderPrintList(head.next);
        System.out.println(head.value);
    }


}

class Node{
    int value;
    Node next;
    public Node(int value){
        this.value=value;
    }
}