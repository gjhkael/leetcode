package algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by havstack on 8/25/15.
 */
public class LRUCache {

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new DLinkedNode();
        this.tail=new DLinkedNode();
        head.pre=null;
        head.post=tail;
        tail.pre=head;
        tail.post=null;
        this.count=0;

    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);

        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }

    }

    public void set(int key, int value) {
        DLinkedNode tmp=cache.get(key);
        if(tmp==null){
            tmp=new DLinkedNode();
            tmp.key=key;
            tmp.value=value;
            this.add(tmp);
            cache.put(key,tmp);
            ++count;
            if(count>capacity){
                DLinkedNode tail=this.popTail();
                this.cache.remove(tail.key);
                --count;
            }

        }else{
            tmp.value=value;
            this.moveToHead(tmp);

        }
    }



    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
        // DLinkedNode(int key,int value){
        //     this.key=key;
        //     this.value=value;
        // }
    }
    //每次添加节点都是往头节点处添加
    public void add(DLinkedNode node){
        node.pre=head;
        node.post=head.post;
        head.post.pre=node;
        head.post=node;

    }
    public void remove(DLinkedNode node){
        DLinkedNode pre=node.pre;
        DLinkedNode post=node.post;
        pre.post=post;
        post.pre=pre;
    }
    public void moveToHead(DLinkedNode node){
        this.remove(node);
        this.add(node);
    }
    public DLinkedNode popTail(){
        DLinkedNode pre=tail.pre;
        this.remove(pre);
        return pre;
    }
    private DLinkedNode head;
    private DLinkedNode tail;
    private HashMap<Integer,DLinkedNode> cache=new HashMap<Integer,DLinkedNode>();
    private int capacity;
    private int count;

}