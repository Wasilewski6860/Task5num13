import java.util.ArrayList;
import java.util.List;

public class Main {

    /*Метод для демонстрации сравнения двух строк в алфавитном порядке*/
    public static void compareStrings(String s1, String s2) {

        if (s1.compareTo(s2) > 0) {
            System.out.println(s1 + " > " + s2);
        } else if (s1.compareTo(s2) < 0) {
            System.out.println(s1 + " < " + s2);
        } else {
            System.out.println(s1 + " == " + s2);
        }


    }


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

        //А < АА < ААА < ААБ < ААВ < АБ < Б < … < ЯЯЯ.

        BinaryTree.TreeNode root = new BinaryTree.TreeNode("Захар");

        root.left = new BinaryTree.TreeNode("Вениамин");
        root.right = new BinaryTree.TreeNode("Матвей");

        root.left.left = new BinaryTree.TreeNode("Анна");
        root.left.right = new BinaryTree.TreeNode("Диана");

        root.right.left = new BinaryTree.TreeNode("Ян");
        root.right.right = new BinaryTree.TreeNode("Евгений");

        List<BinaryTree.TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(root.left);
        list.add(root.right);
        list.add(root.left.left);
        list.add(root.left.right);
        list.add(root.right.left);
        list.add(root.right.right);

        for (BinaryTree.TreeNode n1 : list){
            for (BinaryTree.TreeNode n2 : list){
                System.out.println(BinaryTree.max(n1,n2).value+" по количеству узлов больший из:  "+n1.value+" "+n2.value);
                compareStrings(n1.value, n2.value);
                System.out.println();
            }
        }

        System.out.println("The size of the largest BST is " + BinaryTree.findLargestBST(root).value +" ");

        System.out.println(BinaryTree.toBracketStr(BinaryTree.findLargestBST(root)));
    }
}
