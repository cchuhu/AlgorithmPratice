package Algorithm;

/**
 * Created by zhangwen on 4/19/16.
 * 牛客网笔试题:寻找二叉树的最长路径,节点有黑白两种情况,1为黑色,0为白色.寻找相同色的路径最长的单色路径.
 */
public class LongestPath {
    public static int findPath(TreeNode root) {
        //节点count最大值
        int Max = 0;
        //遍历将二叉树的节点的count成员赋值.
        return find(root, Max);
    }

    public static int find(TreeNode root, int max) {
        if (root == null) {
            //return 0;

        } else {
            if (root.left != null) {
                //如果颜色相同,则将左子树的count值加1.
                if (root.left.value == root.value) {
                    root.left.count += root.count + 1;
                    if (max < root.left.count) {
                        max = root.left.count;
                    }
                }

                find(root.left, max);
            }
            if (root.right != null) {
                //如果颜色相同,则将右子树的count值加1.
                if (root.right.value == root.value) {
                    root.right.count += root.count + 1;
                    if (max < root.right.count) {
                        max = root.right.count;
                    }

                }
                find(root.right, max);
            }

        }

        return max;
    }


    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        //计数值,计算当前节点之前的相同颜色的节点数之和
        int count = 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.value = 1;
        TreeNode left = new TreeNode();
        left.value = 1;
        root.left = left;
        TreeNode right = new TreeNode();
        right.value = 0;
        root.right = right;
        TreeNode left1 = new TreeNode();
        left1.value = 1;
        left.right = left1;
        findPath(root);


    }

}
