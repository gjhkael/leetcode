package algorithm.Tree;

/**
 * Created by havstack on 9/7/15.
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int max(int a,int b){
        return a>b?a:b;
    }
}
