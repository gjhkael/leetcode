package algorithm.Tree;

import java.util.*;

/**
 * Created by hy on 2015/8/8.
 */
public class LevelOrderBottom {

    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        System.out.println(levelOrderBottom(root));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
