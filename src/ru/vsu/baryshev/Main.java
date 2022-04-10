package ru.vsu.baryshev;



public class Main {

    public static void main(String[] args)
    {
		/* Construct the following tree
				  10
				/    \
			   /      \
			  15       8
			 /  \     / \
			/    \   /   \
		   12    20 5     2
		*/

        BinaryTree.TreeNode root = new BinaryTree.TreeNode("Австрия");

        root.left = new BinaryTree.TreeNode("Австри");
        root.right = new BinaryTree.TreeNode("Австрияя");

        root.left.left = new BinaryTree.TreeNode("Австр");
        root.left.right = new BinaryTree.TreeNode("Австрияяя");

        root.right.left = new BinaryTree.TreeNode("Австрия");
        root.right.right = new BinaryTree.TreeNode("Австрия");

        System.out.println("The size of the largest BST is " + BinaryTree.findLargestBST(root)+" ");
    }
}
