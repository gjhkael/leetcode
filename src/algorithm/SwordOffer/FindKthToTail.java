package algorithm.SwordOffer;

/**
 * Created by havstack on 8/28/15.
 */
public class FindKthToTail {
    public static void main(String[] args){



    }

    public static ListNode findKthToTail(ListNode head,int k){
        if(head==null||k<=0){
            return null;
        }
        ListNode first=head;
        ListNode last=head;
        int i=1;
        while(first!=null){
            first=first.next;
            i++;
            if(i==k){
                break;
            }
        }
        if(i<k){
            return null;
        }
        while(first!=null){
            first=first.next;
            last=last.next;
        }
        return last;
    }

}
