package algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by havstack on 9/7/15.
 */
public class MinDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return (left==0||right==0)?left+right+1:Math.min(left, right)+1;
    }

    public int minDepth1(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        int depth = 1;
        while( !queue.isEmpty() ) {
            TreeNode node = queue.remove();
            if(node.left==null && node.right==null) return depth;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null)  queue.add(node.right);
            if(node == endOfLevel) {  // 这里判断，因为只有当node还有子节点的时候，depth++
                endOfLevel = node.right==null ? node.left : node.right;//这里需要使用node.right==null来进行判断，因为node.right才标识一行结束
                depth++;
            }
        }
        return depth;
    }
}
