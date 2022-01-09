package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code116
 * @description https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
 * @date 2022/1/7 15:02
 */
public class Code116 {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        //存储当前节点的左右节点
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            //此处是为了root的第二级子节点的左右相连接
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归的调用左右节点，完成同样的纵深串联
        dfs(root.left);
        dfs(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
