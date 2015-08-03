package leetcode;

/**
 * Created by hy on 2015/8/1.
 */
//与链表操作有关代码
public class PrintListReversely {
    public static void main(String[] args){
        ListNode head=new ListNode(0);
        ListNode tmp=head;
        for(int i=1;i<10;i++){
            tmp.next=new ListNode(i);
            tmp=tmp.next;
        }
        printListReversely(head);

        ListNode result=searchMid(head);
        System.out.println(result.val);

        System.out.println(isLoop(head));

    }
    public static void printListReversely(ListNode head){  //单链表从尾到头打印出来。
        if(head!=null){
            printListReversely(head.next);
            System.out.println(head.val);
        }
    }

    public static ListNode searchMid(ListNode head){ //找单链表中间元素
        if(head==null)
            return  null;
        ListNode first=head;
        ListNode second=head;
        while(first!=null&&first.next!=null) {
            first = first.next.next;
            second = second.next;
        }
        return second;
    }

    public static boolean isLoop(ListNode head){  //判断链表是不是含有循环链表
        if(head==null)
            return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
    public static ListNode findLoopPort(ListNode head){  //判断链表是不是含有循环链表
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                break;
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;

    }
}
