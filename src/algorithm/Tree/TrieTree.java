package algorithm.Tree;

/**
 * Created by hy on 2015/8/12.
 */
public class TrieTree {

    private int SIZE=26;
    private TrieNode root; //字典树的跟
    TrieTree(){               //初始化字典树
        root =new TrieNode();
    }
    private class TrieNode{
        private int num;  //有多少单词通过这个节点，即节点字符出现的次数
        private TrieNode[]son;   //所有的儿子节点
        private boolean isEnd; //是不是最后一个节点
        private char val;
        TrieNode(){
           num=1;
           son=new TrieNode[SIZE];
           isEnd=false;
        }
    }
    //构造树
    public void insert(String str){
        if(str==null||str.length()==0)
            return;
        TrieNode node=root;
        char[] letter=str.toCharArray();
        for(int i=0,len=str.length();i<len;i++){
            int pos=letter[i]-'a';
            if(node.son[pos]==null){
                node.son[pos]=new TrieNode();
                node.son[pos].val=letter[i];
            }else{
                node.son[pos].num++;
            }
            node=node.son[pos];
        }
        node.isEnd=true;
    }

    //计算以单词为前缀的单词数量
    public  int countPrefix(String prefix){
        if(prefix==null||prefix.length()==0)
            return -1;
        TrieNode node=root;
        char[] letter=prefix.toCharArray();
        for(int i=0,len=prefix.length();i<len;i++){
            int pos=letter[i]-'a';
            if(node.son[pos]==null){
                return 0;
            }else{
                node=node.son[pos];
            }
        }
        return node.num;
    }
    //在字典树中查找一个完全匹配的单词.
    public boolean has(String str){
        if(str==null||str.length()==0)
            return false;
        TrieNode node=root;
        char[] letter=str.toCharArray();
        for(int i=0,len=str.length();i<len;i++){
            int pos=letter[i]-'a';
            if(node.son[pos]!=null){
                node=node.son[pos];
            }else
                return false;
        }
        return node.isEnd;
    }

    public void preTraverse(TrieNode node){
        if(node!=null){
            System.out.print(node.val+"-");
            for(TrieNode child:node.son){
                preTraverse(child);
            }
        }
    }

    public TrieNode getRoot(){
        return this.root;
    }


}
