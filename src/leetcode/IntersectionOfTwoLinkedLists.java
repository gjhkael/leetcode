package leetcode;

/**
 * Created by hy on 2015/7/27.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null|| headB==null)
            return null;
        ListNode tmp1=headA;
        ListNode tmp2=headB;
        int sumIndex1=0;
        int sumIndex2=0;
        while(tmp1!=null){
            sumIndex1++;
            tmp1=tmp1.next;
        }
        while(tmp2!=null){
            sumIndex2++;
            tmp2=tmp2.next;
        }
        tmp1=headA;
        tmp2=headB;
        int distance=sumIndex1-sumIndex2;
        if(distance>0){
            for(int i=0;i<distance;i++){
                tmp1=tmp1.next;
            }
        }else{
            for(int i=0;i<(-1)*distance;i++)
                tmp2=tmp2.next;
        }

        while(tmp1!=null){
            if(tmp1==tmp2)
                return tmp1;
            else{
                tmp1=tmp1.next;
                tmp2=tmp2.next;
            }
        }
        return null;
        /*  //简洁算法，真的是很大差距
        if( null==headA || null==headB )
            return null;

        ListNode curA = headA, curB = headB;
        while( curA!=curB){
            curA = curA==null?headB:curA.next;
            curB = curB==null?headA:curB.next;
        }
        return curA;
        */
    }

}
