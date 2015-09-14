package algorithm.Tree;

import java.util.*;

/**
 * Created by hy on 2015/9/14.
 */
public class BinaryTreeLevelOrderTraversal {




    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            ArrayList<Integer>tmp =new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = list.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }
            }
            result.add(tmp);
        }
        Collections.reverse(result);
        return result;
    }
}
