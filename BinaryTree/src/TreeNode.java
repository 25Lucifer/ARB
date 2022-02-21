import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tree
 * @date 2022/2/21 21:05
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode listToTree(Integer[] list) {
        if (list.length == 0 || list[0] == null) {
            return null;
        }
        // [5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(list[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        for (int i = 1; i < list.length; i += 2) {
            TreeNode node = null;
            if (!deque.isEmpty()) {
                node = deque.getFirst();
            }
            if (list[i] != null) {
                node.left = new TreeNode(list[i]);
                deque.addLast(node.left);
            }
            if (list[i + 1] != null) {
                node.right = new TreeNode(list[i + 1]);
                deque.addLast(node.right);
            }
            deque.removeFirst();
        }
        return root;
    }
}











