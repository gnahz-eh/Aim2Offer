class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode() {
		this.val = 0;
		this.left = null;
		this.right = null;
	}
	
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}


public class KthNodeInBST {

	public TreeNode kthNode(TreeNode root, int k) {
		if (root == null || k <= 0)
			return null;
		int[] kth = {k};
		return kthNodeCore(root, kth);
	}
	
	private TreeNode kthNodeCore(TreeNode root, int[] kth) {
		TreeNode target = null;
		if (root.left != null)
			target = kthNodeCore(root.left, kth);
		
		if (target == null) {
			if (kth[0] == 1) 
				target = root;
			kth[0]--;
		}
		
		if (target == null && root.right != null)
			target = kthNodeCore(root.right, kth);
		
		return target; 
	}
	
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t6 = new TreeNode(6);
		
		t5.left = t3;
		t5.right = t7;
		t3.left = t2;
		t3.right = t4;
		t7.left = t6;
		t7.right = t8;
		
		
		KthNodeInBST k = new KthNodeInBST();
		System.out.println(k.kthNode(t5, 5).val);
		
	}
}
