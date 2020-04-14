import java.util.LinkedList;
import java.util.List;

public class _95UniqueBSTII {
    /*
    Given an integer n, generate all structurally unique BST's
    (binary search trees) that store values 1 ... n.
     */
    public List<TreeNode> generateTrees(int n){
        if (n == 0)
            return new LinkedList<TreeNode>();

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> resultList = new LinkedList<>();

        if (start > end){
            resultList.add(null);
            return resultList;
        }

        for (int i = start; i <= end; i++){
            List<TreeNode> allPossibleLeftSubtree = generateTrees(start, i - 1);

            List<TreeNode> allPossibleRightSubtree = generateTrees(i + 1, end);

            for(TreeNode l : allPossibleLeftSubtree){
                for (TreeNode r : allPossibleRightSubtree){
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    resultList.add(currentTree);
                }
            }
        }
        return resultList;
    }
}
