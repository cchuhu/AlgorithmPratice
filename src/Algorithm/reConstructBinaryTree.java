package Algorithm;

import java.util.LinkedList;

/**
 * Created by zhangwen on 4/12/16.
 * 类说明:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class reConstructBinaryTree {
    /**
     * 二叉树节点类
     */
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 重建树的方法
     *
     * @param pre 前序遍历
     * @param in  中序遍历
     * @return
     */
    public static TreeNode ConstructBinaryTree(int[] pre, int[] in) {
        //设置根节点
        TreeNode root = ConstructBinaryTrees(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;


    }

    public static TreeNode ConstructBinaryTrees(int[] pre, int preleft, int preright, int[] in, int inleft, int inright) {

        //如果左右子树的边界未重合
        if (preleft > preright || inleft > inright) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preleft]);
        for (int i = inleft; i <= inright; i++) {
            //找出根节点位置
            if (in[i] == pre[preleft]) {
                //left的第3个参数和right的第2个参数容易出错
                root.left = ConstructBinaryTrees(pre, preleft + 1, preleft + i - inleft, in, inleft, i - 1);
                root.right = ConstructBinaryTrees(pre, i - inleft + preleft + 1, preright, in, i + 1, inright);
            }
        }
        return root;
    }


    /**
     * 逐层遍历,用LinkList实现队列
     *
     * @params
     */
    static LinkedList<TreeNode> queue = new LinkedList();

    public static void everyOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        queue.add(tree);
        while (!queue.isEmpty()) {
            // 返回队列头部第一个元素
            TreeNode node = queue.remove(0);
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }


    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = ConstructBinaryTree(pre, in);
        everyOrder(root);

    }
}
