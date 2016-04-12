package DataStructer;

import java.util.LinkedList;


/**
 * @author Huhu
 * @version 创建时间：Apr 10, 2016 1:31:37 PM 类说明 二叉树的基本操作
 */
public class TreeBasic {
	public class BinaryTree {
		// 根节点
		int root;
		// 左子树
		BinaryTree leftTree;
		// 右子树
		BinaryTree rightTree;
		// 层次遍历的队列
		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();

		/**
		 * 构造函数
		 * 
		 * @param root
		 *            新建树的根节点
		 */
		public BinaryTree(int root) {
			this.root = root;
		}

		/**
		 * 向二叉树中插入节点
		 * 
		 * @params data 要插入的数字 BinartTree 要插入的树
		 */
		public void insert(int data, BinaryTree tree) {
			// 如果数据大于根节点，则应该插入到右子树
			if (data > tree.root) {
				// 如果该树没有右子树，则将新建节点作为右子树
				if (tree.rightTree == null) {
					BinaryTree right = new BinaryTree(data);
					tree.rightTree = right;
				}
				// 如果该树有右子树，则递归插入。
				else {
					this.insert(data, tree.rightTree);
				}
			}
			// 如果该树小于等于根节点
			else {
				// 如果该树没有左子树
				if (tree.leftTree == null) {
					BinaryTree left = new BinaryTree(data);
					tree.leftTree = left;
				}
				// 如果该树有左子树，则递归插入
				else {
					insert(data, tree.leftTree);
				}
			}
		}

		/**
		 * 前序遍历
		 * 
		 * @params tree 要遍历的树
		 */
		public void preOrder(BinaryTree tree) {
			if (tree != null) {
				System.out.print(tree.root+" ");
				preOrder(tree.leftTree);
				preOrder(tree.rightTree);
			}
		}

		/**
		 * 中序遍历
		 * 
		 * @params
		 */
		public void midOrder(BinaryTree tree) {
			if (tree != null) {
				midOrder(tree.leftTree);
				System.out.print(tree.root+" ");
				midOrder(tree.rightTree);
			}
		}

		/**
		 * 后序遍历
		 * 
		 * @params
		 */
		public void postOrder(BinaryTree tree) {
			if (tree != null) {
				postOrder(tree.leftTree);
				postOrder(tree.rightTree);
				System.out.print(tree.root+" ");

			}
		}

		/**
		 * 逐层遍历,用LinkList实现队列
		 * 
		 * @params
		 */
		public void everyOrder(BinaryTree tree) {
			if (tree == null) {
				return;
			}
			queue.add(tree);
			while (!queue.isEmpty()) {
				// 返回队列头部第一个元素
				BinaryTree temp = queue.remove(0);
				System.out.print(temp.root+" ");
				if (temp.leftTree != null) {
					queue.add(temp.leftTree);
				}
				if (temp.rightTree != null) {
					queue.add(temp.rightTree);
				}
			}

		}
	}

	public static void main(String[] args) {
		int[] array = { 55, 10, 8, 96, 2, 0, 3, 6, 24, 62 };
		TreeBasic treeBasic = new TreeBasic();
		BinaryTree binaryTree = treeBasic.new BinaryTree(array[0]);
		// 建树过程
		for (int i = 1; i < array.length; i++) {
			binaryTree.insert(array[i], binaryTree);
		}
		System.out.println("前序遍历结果：");
		binaryTree.preOrder(binaryTree);
		System.out.println("");
		System.out.println("中序遍历结果：");
		binaryTree.midOrder(binaryTree);
		System.out.println("");
		System.out.println("后序遍历结果：");
		binaryTree.postOrder(binaryTree);
		System.out.println("");
		System.out.println("层次遍历结果：");
		binaryTree.everyOrder(binaryTree);
	}
}
