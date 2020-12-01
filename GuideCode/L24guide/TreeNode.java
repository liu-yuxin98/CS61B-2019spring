public class TreeNode {
    public TreeNode left, right;
    public int value;

    public TreeNode(int n) {
        value = n;
    }

    /* Replaces value with sum of all of its descendants' values. */
    public int sumDescendants() {
        if (left == null && right == null) {
            int oldVal = value;
            /* fill code*/
            value = 0;
            return oldVal;

        } else {
            int oldVal = value;

           /* fill code*/
            value = left.sumDescendants()+ right.sumDescendants();

            return oldVal + value;

        }
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(4);
        t3.left = t1;
        t3.right = t2;

        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(8);
        t6.left = t4;
        t6.right = t5;

        TreeNode t7 = new TreeNode(6);
        t7.left = t3;
        t7.right = t6;

        int num = t7.sumDescendants();

    }
}
