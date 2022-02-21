/**
 * @author tree
 * @date 2022/2/21 21:08
 */
public class DFS98 {

    public static void main(String[] args) {
        Integer[] list = {5,1,4,null,null,3,6};
        TreeNode root = TreeNode.listToTree(list);
        new DFS98().isValidBST(root);
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        if (root.left != null) {
            if (!isValidBST(root.left, minVal, root.val)) {
                return false;
            }
        }
        if (root.right != null) {
            if (!isValidBST(root.right, root.val, maxVal)) {
                return false;
            }
        }
        return true;
    }
}
