import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @Test
    void test01() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("М");

        root.left = new BinaryTree.TreeNode("В");
        root.right = new BinaryTree.TreeNode("Э");

        root.left.left = new BinaryTree.TreeNode("А");
        root.left.right = new BinaryTree.TreeNode("Д");

        root.right.left = new BinaryTree.TreeNode("Я");
        root.right.right = new BinaryTree.TreeNode("Е");

        assertTrue(BinaryTree.equals(root.left, BinaryTree.findLargestBST(root)), "Arrays are not equal");
    }

    @Test
    void test02() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("Захар");

        root.left = new BinaryTree.TreeNode("Вениамин");
        root.right = new BinaryTree.TreeNode("Матвей");

        root.left.left = new BinaryTree.TreeNode("Анна");
        root.left.right = new BinaryTree.TreeNode("Диана");

        root.right.left = new BinaryTree.TreeNode("Ян");
        root.right.right = new BinaryTree.TreeNode("Евгений");

        assertTrue(BinaryTree.equals(root.left, BinaryTree.findLargestBST(root)), "Arrays are not equal");
    }

    @Test
    void test03() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("Захар");

        root.left = new BinaryTree.TreeNode("Вениамин");
        root.right = new BinaryTree.TreeNode("Матвей");

        root.left.left = new BinaryTree.TreeNode("Анна");
        root.left.right = new BinaryTree.TreeNode("Диана");

        root.right.left = new BinaryTree.TreeNode("Ян");
        root.right.right = new BinaryTree.TreeNode("Евгений");

        assertTrue(BinaryTree.equals(root.left, BinaryTree.findLargestBST(root)), "Arrays are not equal");
    }

    @Test
    void test04() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("Захар");

        root.left = new BinaryTree.TreeNode("Вениамин");
        root.right = new BinaryTree.TreeNode("Матвей");

        root.left.left = new BinaryTree.TreeNode("Анна");
        root.left.right = new BinaryTree.TreeNode("Диана");

        root.right.left = new BinaryTree.TreeNode("Ян");
        root.right.right = new BinaryTree.TreeNode("Евгений");

        assertTrue(BinaryTree.equals(root.left, BinaryTree.findLargestBST(root)), "Arrays are not equal");
    }

    @Test
    void test05() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("Захар");

        root.left = new BinaryTree.TreeNode("Вениамин");
        root.right = new BinaryTree.TreeNode("Матвей");

        root.left.left = new BinaryTree.TreeNode("Анна");
        root.left.right = new BinaryTree.TreeNode("Диана");

        root.right.left = new BinaryTree.TreeNode("Ян");
        root.right.right = new BinaryTree.TreeNode("Евгений");

        assertTrue(BinaryTree.equals(root.left, BinaryTree.findLargestBST(root)), "Arrays are not equal");
    }
}