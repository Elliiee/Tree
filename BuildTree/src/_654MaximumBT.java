public class _654MaximumBT {
    /*
    put the max num as root, the left to it as left subtree, right to it as right subtree
     */
    public TreeNode constructMaxBT(int[] nums){
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int start, int end){
        if (start > end)
            return null;
        int max_idx = max(nums, start, end);
        TreeNode root = new TreeNode(nums[max_idx]);
        root.left = construct(nums, start, max_idx);
        root.right = construct(nums, max_idx + 1, end);
        return root;
    }

    public int max(int[] nums, int l, int r){
        int max_idx = l;
        for (int i = l; i <= r; i++){
            if (nums[max_idx] < nums[i])
                max_idx = i;
        }
        return max_idx;
    }
}
