package algorithm.Tree;

/**
 * Created by hy on 2015/8/7.
 */

//判断两颗树是不是相同的树，利用递归实现，
//必须要相好递归结束条件，往往会漏掉
public class IsSameTree {
    public static void main(String[] args){
        TreeNode p=new TreeNode(1);
        TreeNode q=new TreeNode(1);
        System.out.println(isSameTree(q,p));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null&&q!=null)||(p!=null&&q==null))
            return false;
        if(q==null&&p==null){
            return true;
        }
        int pValue = p.val;
        int qValue= q.val;
        if(pValue!=qValue)
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);


    }
}
