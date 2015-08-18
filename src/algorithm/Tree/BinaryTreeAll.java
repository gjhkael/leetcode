package algorithm.Tree;

import javax.transaction.TransactionRequiredException;
import java.util.*;

/**
 * Created by hy on 2015/8/11.
 */
public class BinaryTreeAll{
    public static void main(String[] args){
        TreeNode r1 = new TreeNode(6);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(8);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(7);
        TreeNode r7 = new TreeNode(9);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r7;
        r3.left=r6;
        //inOrderTraversalTree(r1);
        //TreeNode head=convertBST2DLLRec(r1);
        //System.out.println(head.right.right.right.left.val);
        System.out.println(getKthLevel(r1,3));
    }
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }

    /*求二叉树中的节点个数
     *递归解法
     */
    public static int getNodeNums(TreeNode root){
        if(root==null)
            return 0;
        return getNodeNums(root.left)+getNodeNums(root.right)+1;
    }
    //利用队列将遍历所有节点
    public static int getNodeNum(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int count=1;
        while(!queue.isEmpty()){
            TreeNode pre=queue.poll();
            if(pre.left!=null){
                queue.add(pre.left);
                count++;
            }
            if(pre.right!=null){
                count++;
                queue.add(pre.right);
            }
        }
        return count;
    }
    /*求二叉树的高度
     *
     */
    public static int max(int a,int b){
        return a>b?a:b;
    }

    public static int depthOfTree(TreeNode root){
        if(root==null)
            return 0;
        return max(depthOfTree(root.right),depthOfTree(root.left))+1;
    }

    /* 前序遍历，中序遍历，后序遍历
     *
     */
    public static void preOrderTraversal(TreeNode root){
        if(root==null)
           return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void preOrderTraversalTree(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pre=stack.pop();
            System.out.println(pre.val);
            if(pre.right!=null)
                stack.push(pre.right);
            if(pre.left!=null)
                stack.push(pre.right);
        }
    }

    //中序遍历
    public static void inOrderTraversal(TreeNode root){
        if(root==null)
            return ;
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    //中序遍历二叉树，如果是有序二叉树，那么中序遍历后的结果是有序的。
    public static void inOrderTraversalTree(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode>stack =new Stack<TreeNode>();
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode pre=stack.pop();
                System.out.println(pre.val);
                if(pre.right!=null)
                    stack.push(pre.right);
            }
        }
    }

    //后序遍历
    public static void postOrderTraversal(TreeNode root){
        if(root==null)
            return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.val);
    }
    //非递归解决后序遍历需要再理解一下
    public static void postOrderTraversalTree(TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> s=new Stack<TreeNode>();
        Stack<TreeNode> outPut=new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur=s.pop();
            outPut.push(cur);
            if(cur.left!=null){
                s.push(cur.left);
            }
            if(cur.right!=null){
                s.push(cur.right);
            }
        }
        while(!outPut.isEmpty())
            System.out.println(outPut.pop().val+" ");
    }

    //层次遍历二叉树
    public static void levelTraversal(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode pre=queue.poll();
            System.out.println(pre.val);
            if(pre.left!=null)
                queue.add(pre.left);
            if(pre.right!=null)
                queue.add(pre.right);
        }
    }

    //利用递归解决二叉树的层次遍历
    public static void levelTraversalTree(TreeNode root){
        if(root==null)
            return;
        ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
        dfs(root,0,result);
        System.out.println(result);
    }
    public static void dfs(TreeNode node,int level,ArrayList<ArrayList<Integer>>ret){
        if(node==null)
            return;
        if(level>=ret.size()){
            ret.add(new ArrayList<Integer>());
        }
        ret.get(level).add(node.val);
        dfs(node.left,level+1,ret);
        dfs(node.right,level+1,ret);
    }
    /**
     * 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针。
     * 递归解法：
     * 参考了http://stackoverflow.com/questions/11511898/converting-a-binary-search-tree-to-doubly-linked-list#answer-11530016
     * 感觉是最清晰的递归解法，但要注意递归完，root会在链表的中间位置，因此要手动
     * 把root移到链表头或链表尾
     */
    public static TreeNode convert(TreeNode root){
        root=convertBST(root);
        while(root.left!=null)
            root=root.left;
        return root;
    }

    public static TreeNode convertBST(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))
            return root;
        TreeNode tmp;
        if(root.left!=null){
            tmp=convertBST(root.left);
            while(tmp.right!=null){
                tmp=tmp.right;
            }
            tmp.right=root;
            root.left=tmp;
        }
        if(root.right!=null){
            tmp=convertBST(root.right);
            while(tmp.left!=null){
                tmp=tmp.left;
            }
            tmp.left=root;
            root.right=tmp;
        }
        return root;
    }

    /**
     * 求二叉树第K层的节点个数   递归解法：
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     *
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目
     *
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解
     *
     */
    public static int getNodeNumKthLevel(TreeNode root, int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1)
            return 1;
        int numLeft=getNodeNumKthLevel(root.left,k-1);
        int numRight=getNodeNumKthLevel(root.right,k-1);
        return numLeft+numRight;
    }

    public static int getKthLevel(TreeNode root, int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1)
            return 1;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int current=1;
        int result=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode pre=queue.poll();
                if(pre.left!=null)
                    queue.add(pre.left);
                if(pre.right!=null)
                    queue.add(pre.right);
            }
            current++;
            if(current==k)
                result=queue.size();
        }
        return result;
    }

    //求二叉树种叶子节点的个数
    public static int getNodeNumLeaf(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        return getNodeNumLeaf(root.left)+getNodeNumLeaf(root.right);
    }

    public static int getNodeNumLeafs(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int result=0;
        while(!queue.isEmpty()){
            TreeNode pre=queue.poll();
            if(pre.left!=null)
                queue.add(pre.left);
            if(pre.right!=null)
                queue.add(pre.right);
            if(pre.left==null&&pre.right==null)
                result++;
        }
        return  result;
    }
    /**
     * 判断两棵二叉树是否相同的树。
     * 递归解法：
     * （1）如果两棵二叉树都为空，返回真
     * （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
     */
    public static boolean isSameTree(TreeNode r1,TreeNode r2){
        if(r1==null&&r2==null)
            return true;
        if(r1==null||r2==null)
            return false;
        if(r1.val!=r2.val)
            return false;
        boolean left=isSameTree(r1.left,r2.left);
        boolean right=isSameTree(r1.right,r2.right);
        return left&&right;
    }

    public static boolean isSame(TreeNode r1,TreeNode r2){
        if(r1==null&&r2==null)
            return true;
        if(r1==null||r2==null)
            return false;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(r1);
        s2.push(r2);
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if(n1==null && n2==null){
                continue;
            }else if(n1!=null && n2!=null && n1.val==n2.val){
                s1.push(n1.right);
                s1.push(n1.left);
                s2.push(n2.right);
                s2.push(n2.left);
            }else{
                return false;
            }
        }
        return true;
    }
/**
 * 判断二叉树是不是平衡二叉树 递归解法：
 * （1）如果二叉树为空，返回真
 * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
 */
    public static boolean isAVLTree(TreeNode root){
        if(root==null)
            return true;
        if(Math.abs(depthOfTree(root.left)-depthOfTree(root.right))>1)
            return false;
        return isAVLTree(root.left)&&isAVLTree(root.right);
    }

    // 3. 判断两个树是否互相镜像
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){
        // 如果两个树都是空树，则返回true
        if(r1==null && r2==null){
            return true;
        }
        // 如果有一棵树是空树，另一颗不是，则返回false
        if(r1==null || r2==null){
            return false;
        }

        // 如果两个树都非空树，则先比较根节点
        if(r1.val != r2.val){
            return false;
        }

        // 递归比较r1的左子树的镜像是不是r2右子树 和
        // r1的右子树的镜像是不是r2左子树
        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);
    }

    //将一颗树转换成其镜像
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    // 2. 不能破坏原来的树，返回一个新的镜像树
    public static TreeNode mirrorCopy(TreeNode root){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> newStack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode newRoot = new TreeNode(root.val);
        newStack.push(newRoot);
        while( !stack.isEmpty() ){
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();

            if(cur.right != null){
                stack.push(cur.right);
                newCur.left = new TreeNode(cur.right.val);
                newStack.push(newCur.left);
            }
            if(cur.left != null){
                stack.push(cur.left);
                newCur.right = new TreeNode(cur.left.val);
                newStack.push(newCur.right);
            }
        }

        return newRoot;
    }
     /*
      *判断一颗树是不是镜像树
      */

    public boolean isSymmetric1(TreeNode root) {
        if(root==null)  return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }
        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }
        return true;
    }

    //求两个节点的最低公共祖先
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

    // 把从根节点到node路径上所有的点都添加到path中
    private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);     // 把这个节点加到路径中
        if (root == node) {
            return true;
        }
        boolean found = false;
        found = getNodePath(root.left, node, path); // 先在左子树中找

        if (!found) {               // 如果没找到，再在右子树找
            found = getNodePath(root.right, node, path);
        }
        if (!found) {               // 如果实在没找到证明这个节点不在路径中，说明刚才添加进去的不是路径上的节点，删掉！
            path.remove(root);
        }
        return found;
    }
    /**
     * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离。 (distance / diameter)
     * 递归解法：
     * （1）如果二叉树为空，返回0，同时记录左子树和右子树的深度，都为0
     * （2）如果二叉树不为空，最大距离要么是左子树中的最大距离，要么是右子树中的最大距离，
     * 要么是左子树节点中到根节点的最大距离+右子树节点中到根节点的最大距离，
     * 同时记录左子树和右子树节点中到根节点的最大距离。
     *
     * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html
     *
     * 计算一个二叉树的最大距离有两个情况:

     情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
     情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
     只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离
     */
    public static Result getMaxDistanceRec(TreeNode root){
        if(root == null){
            Result empty = new Result(0, -1);       // 目的是让调用方 +1 后，把当前的不存在的 (NULL) 子树当成最大深度为 0
            return empty;
        }
        // 计算出左右子树分别最大距离
        Result lmd = getMaxDistanceRec(root.left);
        Result rmd = getMaxDistanceRec(root.right);
        Result res = new Result();
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;        // 当前最大深度
        // 取情况A和情况B中较大值
        res.maxDistance = Math.max( lmd.maxDepth+rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance) );
        return res;
    }

    private static class Result{
        int maxDistance;
        int maxDepth;
        public Result() {
        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }



    /**
     * 13. 由前序遍历序列和中序遍历序列重建二叉树（递归）
     * 感觉这篇是讲的最为清晰的:
     * http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree-from-inorder-and-preorder-traversals/
     * 文中还提到一种避免开额外空间的方法，等下次补上
     */
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder){
        TreeNode root = null;
        List<Integer> leftPreOrder;
        List<Integer> rightPreOrder;
        List<Integer> leftInorder;
        List<Integer> rightInorder;
        int inorderPos;
        int preorderPos;

        if ((preOrder.size() != 0) && (inOrder.size() != 0))
        {
            // 把preorder的第一个元素作为root
            root = new TreeNode(preOrder.get(0));

            //  Based upon the current node data seperate the traversals into leftPreorder, rightPreorder,
            //  leftInorder, rightInorder lists
            // 因为知道root节点了，所以根据root节点位置，把preorder，inorder分别划分为 root左侧 和 右侧 的两个子区间
            inorderPos = inOrder.indexOf(preOrder.get(0));      // inorder序列的分割点
            leftInorder = inOrder.subList(0, inorderPos);
            rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());

            preorderPos = leftInorder.size();                           // preorder序列的分割点
            leftPreOrder = preOrder.subList(1, preorderPos + 1);
            rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());

            root.left = rebuildBinaryTreeRec(leftPreOrder, leftInorder);        // root的左子树就是preorder和inorder的左侧区间而形成的树
            root.right = rebuildBinaryTreeRec(rightPreOrder, rightInorder); // root的右子树就是preorder和inorder的右侧区间而形成的树
        }

        return root;
    }

    /**
     14.  判断二叉树是不是完全二叉树（迭代）
     若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
     第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     有如下算法，按层次（从上到下，从左到右）遍历二叉树，当遇到一个节点的左子树为空时，
     则该节点右子树必须为空，且后面遍历的节点左右子树都必须为空，否则不是完全二叉树。
     */
    public static boolean isCompleteBinaryTree(TreeNode root){
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean mustHaveNoChild = false;
        boolean result = true;

        while( !queue.isEmpty() ){
            TreeNode cur = queue.remove();
            if(mustHaveNoChild){    // 已经出现了有空子树的节点了，后面出现的必须为叶节点（左右子树都为空）
                if(cur.left!=null || cur.right!=null){
                    result = false;
                    break;
                }
            } else {
                if(cur.left!=null && cur.right!=null){      // 如果左子树和右子树都非空，则继续遍历
                    queue.add(cur.left);
                    queue.add(cur.right);
                }else if(cur.left!=null && cur.right==null){    // 如果左子树非空但右子树为空，说明已经出现空节点，之后必须都为空子树
                    mustHaveNoChild = true;
                    queue.add(cur.left);
                }else if(cur.left==null && cur.right!=null){    // 如果左子树为空但右子树非空，说明这棵树已经不是完全二叉完全树！
                    result = false;
                    break;
                }else{          // 如果左右子树都为空，则后面的必须也都为空子树
                    mustHaveNoChild = true;
                }
            }
        }
        return result;
    }

    /**
     * 14.  判断二叉树是不是完全二叉树（递归）
     * http://stackoverflow.com/questions/1442674/how-to-determine-whether-a-binary-tree-is-complete
     *
     */
    public static boolean isCompleteBinaryTreeRec(TreeNode root){
//      Pair notComplete = new Pair(-1, false);
//      return !isCompleteBinaryTreeSubRec(root).equalsTo(notComplete);
        return isCompleteBinaryTreeSubRec(root).height != -1;
    }

    // 递归判断是否满树（完美）
    public static boolean isPerfectBinaryTreeRec(TreeNode root){
        return isCompleteBinaryTreeSubRec(root).isFull;
    }

    // 递归，要创建一个Pair class来保存树的高度和是否已满的信息
    public static Pair isCompleteBinaryTreeSubRec(TreeNode root){
        if(root == null){
            return new Pair(0, true);
        }

        Pair left = isCompleteBinaryTreeSubRec(root.left);
        Pair right = isCompleteBinaryTreeSubRec(root.right);

        // 左树满节点，而且左右树相同高度，则是唯一可能形成满树（若右树也是满节点）的情况
        if(left.isFull && left.height==right.height){
            return new Pair(1+left.height, right.isFull);
        }

        // 左树非满，但右树是满节点，且左树高度比右树高一
        // 注意到如果其左树为非完全树，则它的高度已经被设置成-1，
        // 因此不可能满足第二个条件！
        if(right.isFull && left.height==right.height+1){
            return new Pair(1+left.height, false);
        }

        // 其他情况都是非完全树，直接设置高度为-1
        return new Pair(-1, false);
    }

    private static class Pair{
        int height;             // 树的高度
        boolean isFull;     // 是否是个满树
        public Pair(int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }
        public boolean equalsTo(Pair obj){
            return this.height==obj.height && this.isFull==obj.isFull;
        }
    }


}
