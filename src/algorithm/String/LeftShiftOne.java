package algorithm.String;
/*
 * 旋转字符串、将字符串的前n个字符移到后面去
 */
public class LeftShiftOne {
	//使用java String类提供的方法进行操作
	public static String leftshift(String s,int n){
		String temp1=s.substring(n);
		String temp2=s.substring(0, n);
		return temp1+temp2;
	}
	//使用暴力破解法
	public static void leftRotateOne(char[] s){
		char temp=s[0];
		for(int i=1;i<s.length;i++){
			s[i-1]=s[i];
		}
		s[s.length-1]=temp;
		
	}
	public static void leftRotateString(char[] s,int n){
		for(int j=0;j<n;j++){
			leftRotateOne(s);
		}
	}
	
	//使用三次旋转法
	public static void leftRotateOne(char[] s,int start,int end){
		while(start<end){
			char temp=s[start];
			s[start++]=s[end];
			s[end--]=temp;
		}
	}
	public static void leftRotateChar(char[] s,int n){
		leftRotateOne(s,0,n-1);
		leftRotateOne(s,n,s.length-1);
		leftRotateOne(s,0,s.length-1);
		
	}
	
	//1、链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
	
	public static Node ListRotate(Node start, Node end){
		Node pre=null;
		Node cur=start;
		Node next=cur.next;
		while(cur!=end){
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
	}
	
	public static Node ListRotateWithN(Node list,int n){
		Node mid=list;
		for(int i=1;i<=n;i++){
			mid=mid.next;
		}
		Node l=ListRotate(list,mid);
		Node r=ListRotate(mid,null);
		list.next=r;
		return l;
	}
	
	
	//将一个句子中的单词进行倒序输出单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。为简单起见，标点符
	//* 号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
	
	public static void SentenceRo(char[] sentence){
		int start=0,end=-1;
		for(int i=0;i<sentence.length;i++){
			if(sentence[i]==' '){
				start=end+1;
				end=i;
				while(start<end){                  //每个单词进行旋转
					char temp=sentence[start];
					sentence[start++]=sentence[--end];
					sentence[end]=temp;
				}
				end=i;
			}
			
			if(i==sentence.length-1){
				start=end+1;
				end=i+1;
				while(start<end){
					char temp=sentence[start];
					sentence[start++]=sentence[--end];
					sentence[end]=temp;
				}
			}

		}
		start=0;end=sentence.length;      //整个句子进行旋转
		while(start<end){
			char temp=sentence[start];
			sentence[start++]=sentence[--end];
			sentence[end]=temp;
		}
	}

	public static void main(String[] args){
		String result=leftshift("abcdef",3);
		System.out.println(result);
		
		char[] s="abcdef".toCharArray();
		leftRotateString(s,3);
		System.out.println(s);
		
		leftRotateChar(s,2);
		System.out.println(s);
		
		Node start=new Node(1);
		start.next=new Node(2);
		start.next.next=new Node(3);
		
		/*Node re=ListRotate(start,start.next.next);
		while(re!=null){
			System.out.println(re.data);
			re=re.next;
		}*/
	Node re=ListRotateWithN(start,2);
		while(re!=null){
			System.out.println(re.data);
			re=re.next;
		}
		
		char sentence[]="hello world wo ni".toCharArray();
		SentenceRo(sentence);
		for(int i=0;i<sentence.length;i++){
			System.out.print(sentence[i]);
		}
	}
}


class Node{
	public Node(int data){
		this(data, null);
	}
	public Node(int data, Node next){
		this.data=data;
		this.next=next;
	}
    int data;
	Node next;
}
