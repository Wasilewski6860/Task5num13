package ru.vsu.baryshev;


/*Задача -- В заданном двоичном дереве для строк найти поддерево двоичного поиска с максимальным количеством элементов.
* Данный вариант значительно упрощен -- а)Дерево не строк, а чисел, б) Получаем не поддерево, а его длину
*
*  Двоичное дерево поиска (англ. binary search tree, BST) — двоичное дерево, для которого выполняются следующие дополнительные условия (свойства дерева поиска):

    оба поддерева — левое и правое — являются двоичными деревьями поиска;
    у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
    у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.

*
* */
class BinaryTree {

    /*Класс для узла бинарного дерева поиска(далее -- БДП)*/
    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

       public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }

    }

/*Корень БДП*/
    static TreeNode root;


/*Метод поиска размера БДП*/
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + 1 + size(root.right);
    }


    /*Проверка на то, является ли узел вершиной БДП*/
    public static boolean isBST(TreeNode root){
        /*Случай, когда дошли до низа дерева*/
        if (root == null) {
            return true;
        }

       /*Проверка на то, является ли узел вершиной БДП, т.е. не противоречит ли основным принципам:
           * у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
             у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.
             *
         Т.е. если левое значение больше корня или правое меньше, и сравниваемый узел не null*/
        if (root.value < root.left.value && root.left !=null || root.value > root.right.value && root.right !=null  /* значение корня справа*/  ) {
            return false;
        }

        /*Рекурсивный вызов для узлов справа и слева*/
        return isBST(root.left) && isBST(root.right);
    }

    /*Поиск наибольшего БДП*/
    public static int findLargestBST(TreeNode root) {
        /*Метод будет вызываться для корня всего дерева, поэтому изначально проверяем, является ли БДП корень исходного дерева*/
        if (isBST(root)) {
            return size(root);
        }

        /*Выбираем наибольшую длину из деревьев справа и слева*/
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


