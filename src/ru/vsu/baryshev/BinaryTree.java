package ru.vsu.baryshev;


class BinaryTree {

    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

       public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }

    }


    static TreeNode root;


    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + 1 + size(root.right);
    }

    public static boolean isBST(TreeNode root){

        if (root == null) {
            return true;
        }

        if ( root.value <  root.left.value /* значение корня слева */ || root.value >   root.right.value  /* значение корня справа*/  ) {
            return false;
        }

        return isBST(root.left) && isBST(root.right);
}

    public static int findLargestBST(TreeNode root) {

        if (isBST(root)) {
            return size(root);
        }

        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left= new TreeNode(8);
        root.right= new TreeNode(7);

        root.left.right= new TreeNode(11);
        root.left.left= new TreeNode(3);

        root.right.right= new TreeNode(12);
        root.right.left= new TreeNode(6);

        root.right.left.right= new TreeNode(9);
        root.right.left.left= new TreeNode(3);



        System.out.println("Размер максимального двоичного дерева поиска " + findLargestBST(root));
    }
}


