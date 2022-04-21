package ru.vsu.cs.course1.tree.bst;

import ru.vsu.cs.course1.tree.BinaryTree;

public class BSTreeAlgorithms {
    /**
     * Поиск TreeNode по значению в поддереве node
     *
     * @param node Узел дерева
     * @param value Значение для поиска
     * @return Узел, содержащий искомый элемент
     */
    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getNode(BinaryTree.TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = node.getValue().compareTo(value);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return getNode(node.getLeft(), value);
        } else {
            return getNode(node.getRight(), value);
        }
    }

    /*
      Реализации без рекурсии (для сравнения)

     public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getNode(BinaryTree.TreeNode<T> node, T value) {
        while (node != null) {
            int cmp = node.getValue().compareTo(value);
            if (cmp == 0) {
                break;
            } else if (cmp > 0) {
                return node = node.getLeft();
            } else {
                return node = node.getRight();
            }
        }
        return node;
    }
     */

    /**
     * Поиск минимального TreeNode в поддереве node
     *
     * @param node Поддерево в котором надо искать минимальный элемент
     * @return Узел, содержащий минимальный элемент
     */
    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getMinNode(BinaryTree.TreeNode<T> node) {
        return (node == null || node.getLeft() == null) ? node : getMinNode(node.getLeft());
    }

    /*
      Реализации без рекурсии (для сравнения)

    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getMinNode(BinaryTree.TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

     */

    /**
     * Поиск максимального TreeNode в поддереве node
     *
     * @param node Узел дерева
     * @return Узел, содержащий максимальный элемент
     */
    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getMaxNode(BinaryTree.TreeNode<T> node) {
        return (node == null || node.getRight() == null) ? node : getMaxNode(node.getRight());
    }

    /**
     * Поиск TreeNode с наибольшим значением, меньшим или равным value, в
     * поддереве node
     *
     * @param node Узел дерева
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getFloorNode(BinaryTree.TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return getFloorNode(node.getLeft(), value);
        } else {
            BinaryTree.TreeNode<T> res = getFloorNode(node.getRight(), value);
            return (res != null) ? res : node;
        }
    }

    /**
     * Поиск TreeNode с наименьшим значением, большим или равным value, в
     * поддереве node
     *
     * @param node Узел дерева
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> getCeilingNode(BinaryTree.TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return getCeilingNode(node.getRight(), value);
        } else {
            BinaryTree.TreeNode<T> res = getCeilingNode(node.getLeft(), value);
            return (res != null) ? res : node;
        }
    }




                //Отсюда уже мое
//    public static <T extends Comparable<? super T>> boolean equals(BinaryTree.TreeNode<T> root1, BinaryTree.TreeNode<T> root2) {
//
//        if (root1 == root2) {
//            return true;
//        }
//        if (root1 == null || root2 == null) {
//            return false;
//        }
//        return root1.getValue().equals(root2.getLeft()) && equals(root1.getLeft(), root2.getLeft()) && equals(root1.getRight(), root2.getRight());
//    }
//
//    public static <T extends Comparable<? super T>> int compareStrings(String s1, String s2) {
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


    /*Метод поиска размера БДП*/
    public static <T extends Comparable<? super T>> int size(BinaryTree.TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return size(root.getLeft())  + size(root.getRight())+ 1;
    }

    /*Проверка на то, является ли узел вершиной БДП*/
    public static <T extends Comparable<? super T>> boolean isBST(BinaryTree.TreeNode<T> node) {

        if (node == null) {
            return true;
        }

        /*Проверка на то, является ли узел вершиной БДП, т.е. не противоречит ли основным принципам:
//           * у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
//             у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.
//             *
//         Т.е. если левое значение больше корня или правое меньше, и сравниваемый узел не null*/

        if (node.getLeft() != null && node.getRight() !=null) {

            /*Закомментированы различные варианты сравнения*/
            if (node.getValue().compareTo(node.getLeft().getValue()) < 0 /*compareStrings(node.value,node.left.value) <0*/ || node.getValue().compareTo(node.getRight().getValue()) >= 0 /*compareStrings(node.value,node.right.value) > 0*/) {
                return false;
            }

        }

        return isBST(node.getLeft()) && isBST(node.getRight());
    }

    /*Метод, возвращающий поддерево большего размера*/
    public  static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> max(BinaryTree.TreeNode<T> n1, BinaryTree.TreeNode<T> n2){
        return size(n1)>size(n2) ? n1 : n2;
    }

    /*Поиск наибольшего БДП*/
    public static <T extends Comparable<? super T>> BinaryTree.TreeNode<T> findLargestBST(BinaryTree.TreeNode<T> root) {

        /*Метод будет вызываться для корня всего дерева, поэтому изначально проверяем, является ли БДП корень исходного дерева*/

        if (isBST(root)) {
            return root;
        }

        /*Выбираем наибольшую длину из деревьев справа и слева*/
        return max(findLargestBST(root.getLeft()), findLargestBST(root.getRight()));

    }




}
