import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> resultEachLevel = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                resultEachLevel.add(node.val);
                if (node.left != null) // need add the check otherwise it will throw null pointer error
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            resultList.add(resultEachLevel);
        }
        return resultList;
    }
}
