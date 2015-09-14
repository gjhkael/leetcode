package algorithm.Tree;

import java.util.*;

/**
 * Created by hy on 2015/9/14.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Stack<List<Integer>> stack=new Stack<List<Integer>>();
        //TreeNode pre=null;
        TreeNode cur=root;
        queue.add(cur);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode tmp=queue.poll();
                list.add(tmp.val);
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);

            }
            stack.push(list);
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
