package algorithm.leetcode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by hy on 2015/9/14.
 */
/*
    搞清楚常用的集合类的API使用。ArrayList、LinkedList、Stack、Queue、HashMap、HashSet
 */



public class AAA {
    public static void main(String[] args){
       // new AAA().list();
       // new AAA().map();
        new AAA().set();
    }
    public void list(){ // ArrayList、LinkedList、Vector（线程安全）
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.addAll(Arrays.asList(1,2,3)); //addAll可以使Collection的集合、也可以是Arrays.asList()
        array.add(2);
        //array.remove(1);
        array.removeAll(Arrays.asList(1,2,3));  //removeAll是将整个集合中所有的涉及到的数全部删除
        for(Integer s: array){
            System.out.println(s);
        }

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.addFirst(12);                      //比ArrayList多了一个addFirst、addLast方法 removeFirst() removeLast();
        list.addLast(13);
        list.addAll(Arrays.asList(12));
        list.removeFirst();
        list.removeLast();
        for(Integer s: list){
            System.out.println(s);
        }

        Vector<Integer> vector =new Vector<Integer>();  //1）  Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。
                                                        // 2） 当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。
        vector.add(12);


    }
    public void map(){   //HashMap、TreeMap、LinkedHashMap、ConcurrentHashMap、HashTable
        HashMap<Integer,String> hashMap = new HashMap<Integer, String>();
        hashMap.put(12,"sfd2");
        hashMap.put(11,"sfd1");
        hashMap.put(13,"sfd3");
        boolean t=hashMap.containsKey(12);
        String s=hashMap.get(12);  //获得key对应的value值
        hashMap.remove(12);        //移除key
        hashMap.put(12, s + "hello");  //更新key为12的value值
        System.out.println(t + " " + s + " ");
        Iterator iter = hashMap.entrySet().iterator();
        hashMap.isEmpty();
        while(iter.hasNext()){   //遍历该hashMap
            Map.Entry entry = (Map.Entry)iter.next();
            Integer in = (Integer)entry.getKey();
            String ss=(String)entry.getValue();
            System.out.println(in+" "+ss);
        }

    }
    public void stack(){ //
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.pop();
        stack.isEmpty();
    }
    public void queue(){ //
        Queue<Integer> queue = new LinkedList<Integer>();
        queue = new PriorityQueue<Integer>();
        queue = new ArrayBlockingQueue<Integer>(12);
        queue = new LinkedBlockingQueue<Integer>(12);
        queue.add(12); //添加元素
        queue.poll();  //删除元素
        queue.peek(); //查看队列队头元素

    }
    public void set(){  //TreeSet、HashSet、LinkedHashSet
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(12);
        hashSet.add(13);
        hashSet.remove(12);
        for(Integer s:hashSet){
            System.out.println(s);
        }
    }

}
