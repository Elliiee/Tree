import java.util.HashMap;

public class _106ConstructBTFromInorderPostorder {
    private int post_idx;
    private int[] inorder;
    private int[] postorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    private TreeNode buildTree(int start, int end){
        if (start > end)
            return null;

        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root.val);

        post_idx--;
        root.right = buildTree(index + 1, end);
        root.left = buildTree(start, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for (Integer val : inorder){
            idx_map.put(val, idx++);
        }
        return buildTree(0, postorder.length - 1);
    }
}
