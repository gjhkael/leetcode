package leetcode;

/**
 * Created by hy on 2015/7/27.
 */
public class LowestAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null){
            return null;
        }
        TreeNode tmp=root;
        if((tmp.val>=p.val&&tmp.val<=q.val)||(tmp.val<=p.val&&tmp.val>=q.val)){
            return tmp;
        }else if(tmp.val>=p.val&&tmp.val>=q.val){
            return lowestCommonAncestor(tmp.left,p,q);
        }else{
            return lowestCommonAncestor(tmp.right,p,q);
        }
    }
}
