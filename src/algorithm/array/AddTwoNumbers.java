package algorithm.array;
/*
 * 两个字符串各个位求和，结果进位形式往上加
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n3=null;
        int flag=0;
        ListNode result=null;
        while(l1!=null||l2!=null){
            if(l1!=null){
                flag+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                flag+=l2.val;
                l2=l2.next;
            }
            if(n3==null){
                n3=new ListNode(flag%10);
                result=n3;
            }else{
                n3.next= new ListNode(flag%10);
                n3=n3.next;
            }
            flag=flag/10;
        }
        if(flag!=0){
            n3.next=new ListNode(1);
        }
        
        return result;

    }
		
	public static void main(String[] args) {
		ListNode a=new ListNode(5);
	//	a.next=new ListNode(4);
//		a.next.next=new ListNode(3);
		
		ListNode b=new ListNode(5);
	//	b.next=new ListNode(6);
		//b.next.next=new ListNode(4);
		
		ListNode result=new AddTwoNumbers().addTwoNumbers(a,b);
		System.out.println(result.val+" "+result.next.val+" ");
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}