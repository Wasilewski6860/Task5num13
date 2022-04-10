
class BinaryTree {
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

    /*Класс для узла бинарного дерева поиска(далее -- БДП)*/
    static class TreeNode {
        String value;

        TreeNode left;
        TreeNode right;

       public TreeNode(String data) {
            this.value = data;
        }
    }

    public static boolean equals(TreeNode root1, TreeNode root2) {

        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value.equals(root2.value) && equals(root1.left, root2.left) && equals(root1.right, root2.right);
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


    /*Метод поиска размера БДП*/
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return size(root.left)  + size(root.right)+ 1;
    }

    /*Проверка на то, является ли узел вершиной БДП*/
    public static boolean isBST(TreeNode node) {

        if (node == null) {
            return true;
        }

        /*Проверка на то, является ли узел вершиной БДП, т.е. не противоречит ли основным принципам:
//           * у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
//             у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.
//             *
//         Т.е. если левое значение больше корня или правое меньше, и сравниваемый узел не null*/
        if (node.left != null && node.right !=null) {
            int t1 = node.value.compareTo(node.left.value);
            int t2 = node.value.compareTo(node.right.value);
            /*Закомментированы различные варианты сравнения*/
            if (t1 < 0 /*compareStrings(node.value,node.left.value) <0*/ || t2 >= 0 /*compareStrings(node.value,node.right.value) > 0*/) {
                return false;
            }
        }
        return isBST(node.left) && isBST(node.right);
    }

    /*Метод, возвращающий поддерево большего размера*/
    public  static TreeNode max(TreeNode n1, TreeNode n2){
        return size(n1)>size(n2) ? n1 : n2;
    }

    /*Поиск наибольшего БДП*/
    public static TreeNode findLargestBST(TreeNode root) {
        /*Метод будет вызываться для корня всего дерева, поэтому изначально проверяем, является ли БДП корень исходного дерева*/
        boolean check = isBST(root);
        if (check) {
            return root;
        }
        /*Выбираем наибольшую длину из деревьев справа и слева*/
        return max(findLargestBST(root.left), findLargestBST(root.right));
    }

/*Метод для отображения дерева в виде строки*/
    public static <T> String toBracketStr(TreeNode treeNode) {

        // данный класс нужен только для того, чтобы "спрятать" его метод (c 2-мя параметрами)
        class Inner {
            void printTo(TreeNode node, StringBuilder sb) {
                if (node == null) {
                    return;
                }
                sb.append(node.value);
                if (node.left != null || node.right != null) {
                    sb.append(" (");
                    printTo(node.left, sb);
                    if (node.right != null) {
                        sb.append(", ");
                        printTo(node.right, sb);
                    }
                    sb.append(")");
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // класс приходится создавать, т.к. статические методы в таких класс не поддерживаются
        new Inner().printTo(treeNode, sb);

        return sb.toString();

    }

}
