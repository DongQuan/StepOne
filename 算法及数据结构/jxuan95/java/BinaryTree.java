package jxuan95.java;

import javax.swing.tree.TreeNode;

/**
 * Created by jxuan on 16-3-19.
 * 构建二叉树
 */
public class BinaryTree {
    private TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode(1, "rootNode(A)");
    }

    private class TreeNode {
        private int key = 0;
        private String data = null;
        private boolean isVisted = false;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode() {
        }

        /**
         * @param key  层序编码
         * @param data 数据域
         */
        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }


    }
}
