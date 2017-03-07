import sun.reflect.generics.tree.Tree;

/**
 * Created by Administrator on 2017/3/7.
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode () {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ConvertBinarySearchTree {

    TreeNode convert(TreeNode root) {
        TreeNode lastNodeInList = null;
        lastNodeInList = convertNode(root, lastNodeInList);
        TreeNode head = lastNodeInList;
        while (head.left != null)
            head = head.left;
        return head;
    }

    TreeNode convertNode(TreeNode root, TreeNode lastNodeInList) {
        if (root == null)
            return lastNodeInList;
        TreeNode current = root;

        if (current.left != null)
            lastNodeInList = convertNode(current.left, lastNodeInList);
        current.left = lastNodeInList;
        if (lastNodeInList != null)
            lastNodeInList.right = current;
        lastNodeInList = current;
        if (current.right != null)
            lastNodeInList = convertNode(current.right, lastNodeInList);
        return lastNodeInList;
    }

    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);
        TreeNode t14 = new TreeNode(14);
        TreeNode t12 = new TreeNode(12);
        TreeNode t16 = new TreeNode(16);

        t10.left = t6;
        t10.right = t14;
        t6.left = t4;
        t6.right = t8;
        t14.left = t12;
        t14.right = t16;

        ConvertBinarySearchTree c = new ConvertBinarySearchTree();

        TreeNode res = c.convert(t10);

        while (res != null) {
            System.out.print(res.val + "->");
            res = res.right;
        }

    }
}
