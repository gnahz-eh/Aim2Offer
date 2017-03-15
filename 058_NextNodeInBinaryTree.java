/**
 * Created by Administrator on 2017/3/15.
 */
public class NextNodeInBinaryTree {

    public TreeNode getNext(TreeNode node) {
        if (node == null)
            return null;
        TreeNode next = null;

        if (node.right != null) {
            TreeNode r = node.right;
            while (r.left != null)
                r = r.left;
            next = r;
        } else if (node.parent != null) {
            TreeNode curr = node;
            TreeNode p = node.parent;
            while (p != null && curr == p.right) {
                curr = p;
                p = p.parent;
            }
            next = p;
        }
        return next;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        TreeNode h = new TreeNode('h');
        TreeNode i = new TreeNode('i');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;

        h.parent = e;
        i.parent = e;
        d.parent = b;
        e.parent = b;
        f.parent = c;
        g.parent = c;
        b.parent = a;
        c.parent = a;

        NextNodeInBinaryTree n = new NextNodeInBinaryTree();
        System.out.print((char)(n.getNext(e).val));

    }
}
