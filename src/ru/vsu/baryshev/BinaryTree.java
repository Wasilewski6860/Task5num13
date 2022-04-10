//package ru.vsu.baryshev;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
///*Задача -- В заданном двоичном дереве для строк найти поддерево двоичного поиска с максимальным количеством элементов.
//* Данный вариант значительно упрощен -- а)Дерево не строк, а чисел, б) Получаем не поддерево, а его длину
//*
//*  Двоичное дерево поиска (англ. binary search tree, BST) — двоичное дерево, для которого выполняются следующие дополнительные условия (свойства дерева поиска):
//
//    оба поддерева — левое и правое — являются двоичными деревьями поиска;
//    у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
//    у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.
//
//*
//* */
//class BinaryTree {
//
//    /*Класс для узла бинарного дерева поиска(далее -- БДП)*/
//    static class TreeNode {
//
//        int value;
//        TreeNode left;
//        TreeNode right;
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public TreeNode getLeft() {
//            return left;
//        }
//
//        public TreeNode getRight() {
//            return right;
//        }
//
//        public void setLeft(TreeNode left) {
//            this.left = left;
//        }
//
//        public void setRight(TreeNode right) {
//            this.right = right;
//        }
//
//        public TreeNode(int value) {
//            this.value = value;
//            left = right = null;
//        }
//
//    }
//
//    static class TempValue{
//
//        TreeNode node;
//        int size;
//        boolean isSuitable;
//
//        public int getSize() {
//            return size(node);
//        }
//
//        public TreeNode getNode() {
//            return node;
//        }
//
//        public void setNode(TreeNode node) {
//            this.node = node;
//        }
//
//        public void setSize(int size) {
//            this.size = size;
//        }
//
//        public  TempValue(TreeNode node, int size,boolean isSuitable){
//            this.node=node;
//            this.size=size;
//            this.isSuitable=isSuitable;
//        }
//    }
//
///*Корень БДП*/
//    static TreeNode root;
//
//
///*Метод поиска размера БДП*/
//    public static int size(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return size(root.left) + 1 + size(root.right);
//    }
//
//    public static List<TempValue> treeToList(TreeNode root, List<TempValue> list){
//        if (root == null){
//            return list;
//        }
//        list.add(new TempValue(root,size(root),isBST(root) ));
//        if (root.left !=null)
//        return treeToList(root.left,list);
//        else return treeToList(root.right,list);
//    }
//
//
//    /*Проверка на то, является ли узел вершиной БДП*/
//    public static boolean isBST(TreeNode root){
//        /*Случай, когда дошли до низа дерева*/
//        if (root == null) {
//            return true;
//        }
//
//       /*Проверка на то, является ли узел вершиной БДП, т.е. не противоречит ли основным принципам:
//           * у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
//             у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.
//             *
//         Т.е. если левое значение больше корня или правое меньше, и сравниваемый узел не null*/
//        if (root.left !=null && root.right !=null)
//        if (root.value < root.left.value && root.left !=null || root.value > root.right.value && root.right !=null  /* значение корня справа*/  ) {
//            return false;
//        }
//
//        /*Рекурсивный вызов для узлов справа и слева*/
//        return isBST(root.left) && isBST(root.right);
//    }
//
//    /*Поиск наибольшего БДП*/
//    public static int findLargestBST(TreeNode root) {
//        /*Метод будет вызываться для корня всего дерева, поэтому изначально проверяем, является ли БДП корень исходного дерева*/
//        if (isBST(root)) {
//            return  size(root);
//        }
//
//
//
////        /*Выбираем наибольшую длину из деревьев справа и слева*/
//        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
//    }
//
//    public static TreeNode solution(TreeNode root){
//
//        List<TempValue> list = new ArrayList<>();
//        list=treeToList(root,list);
//        TempValue value = list.get(0);
//        System.out.println(value.getNode().getValue());
//
//        for (int i=0;i< list.size();i++){
//            System.out.println(list.get(i).getSize()+" "+list.get(i).getNode().getValue());
//        }
//
//        for (int i=0;i< list.size();i++){
//           if (list.get(i).getSize()> value.getSize()) value= list.get(i);
//
//        }
//        return value.node;
//    }
//
//    public static int compare(String a, String b){
//        return a.compareTo(b);
//    }
//
//
//
//
//
//    public static <T> String toBracketStr(TreeNode treeNode) {
//        // данный класс нужен только для того, чтобы "спрятать" его метод (c 2-мя параметрами)
//        class Inner {
//            void printTo(TreeNode node, StringBuilder sb) {
//                if (node == null) {
//                    return;
//                }
//                sb.append(node.value);
//                if (node.left != null || node.right != null) {
//                    sb.append(" (");
//                    printTo(node.left, sb);
//                    if (node.right != null) {
//                        sb.append(", ");
//                        printTo(node.right, sb);
//                    }
//                    sb.append(")");
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        // класс приходится создавать, т.к. статические методы в таких класс не поддерживаются
//        new Inner().printTo(treeNode, sb);
//
//        return sb.toString();
//    }
//
//
//    public static int compareStrings(String s1, String s2) {
//
//        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
//            if ((int) s1.charAt(i) == (int) s2.charAt(i)) {
//                continue;
//            } else {
//                return (int) s1.charAt(i) - (int) s2.charAt(i);
//            }
//        }
//
//        if (s1.length() < s2.length()) {
//            return (s1.length() - s2.length());
//        } else if (s1.length() > s2.length()) {
//            return (s1.length() - s2.length());
//        } else {
//            return 0;
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//        TreeNode root = new TreeNode(10);
//
//        root.left= new TreeNode(8);
//        root.right= new TreeNode(7);
//
//        root.left.right= new TreeNode(11);
//        root.left.left= new TreeNode(3);
//
//        root.right.right= new TreeNode(12);
//        root.right.left= new TreeNode(6);
//
//        root.right.left.right= new TreeNode(9);
//        root.right.left.left= new TreeNode(3);
//
////        TreeNode root = new TreeNode("Шапка");
////
////        root.left = new TreeNode("Ивраамм");
////        root.right = new TreeNode("Аввакуум");
////
////        root.left.left = new TreeNode("Линкольн");
////        root.left.right = new TreeNode("Гастрит");
////
////        root.right.left = new TreeNode("Папка");
////        root.right.right = new TreeNode("Лапка");
////
////        System.out.println(compare(root.value,root.left.value));
//        System.out.println("Размер максимального двоичного дерева поиска " + findLargestBST(root));
//    }
//}

package ru.vsu.baryshev;


// A class to store a BST node


class BinaryTree {

    static class TreeNode {
        // stores value of this node
        String data;

        // stores left and right child for this node
        TreeNode left;
        TreeNode right;

        // constructor
        TreeNode(String data) {
            this.data = data;
        }
    }


    public static int compareStrings(String s1, String s2) {

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if ((int) s1.charAt(i) == (int) s2.charAt(i)) {
                continue;
            } else {
                return (int) s1.charAt(i) - (int) s2.charAt(i);
            }
        }

        if (s1.length() < s2.length()) {
            return (s1.length() - s2.length());
        } else if (s1.length() > s2.length()) {
            return (s1.length() - s2.length());
        } else {
            return 0;
        }
    }


    // Recursive function to calculate the size of a given binary tree
    public static int size(TreeNode root) {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }

        // recursively calculate the size of the left and right subtrees and
        // return the sum of their sizes + 1 (for root node)
        return size(root.left)  + size(root.right)+ 1;
    }


    // Recursive function to determine if a given binary tree is a BST or not
    // by keeping a valid range (starting from [-INFINITY, INFINITY]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(TreeNode node) {
        // base case
        if (node == null) {
            return true;
        }

        // if the node's value falls outside the valid range
        if (node.left != null && node.right !=null)
        if (  compareStrings(node.data,node.left.data) <0 /*node.data < node.left.data*/   ||  compareStrings(node.data,node.right.data) >0  /*node.data > node.right.data*/   ) {
            return false;
        }

        // recursively check left and right subtrees with updated range
        return isBST(node.left) && isBST(node.right);
    }


    // Recursive function to find the size of the largest BST in a given binary tree
    public static int findLargestBST(TreeNode root) {
        if (isBST(root)) {
            return size(root);
        }

        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }


}
