import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Administrator on 2017/3/12.
 */
public class CommonParentInTree {

    private boolean getNodePath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null) return false;
        if (root == node) {
            stack.push(root);
            return true;
        } else {
            if (getNodePath(root.left, node, stack) || getNodePath(root.right, node, stack)) {
                stack.push(root);
                return true;
            }
        }
        return false;
    }

    private TreeNode lowestCommonAncestor(Stack<TreeNode> p, Stack<TreeNode> q) {
        TreeNode target = null;
        while (!p.empty() && !q.empty() && p.peek() == q.peek()) {
            target = p.peek();
            p.pop();
            q.pop();
        }
        return target;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        Stack<TreeNode> p = new Stack<>();
        Stack<TreeNode> q = new Stack<>();
        getNodePath(root, node1, p);
        getNodePath(root, node2, q);
        return lowestCommonAncestor(p, q);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t4.right = t7;
        t5.left = t8;
        t5.right = t9;

        CommonParentInTree c = new CommonParentInTree();
        TreeNode res = c.lowestCommonAncestor(t1, t1, t2);
        System.out.print(res.val);
    }
}

