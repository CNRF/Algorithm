package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wmx
 * @version 1.0
 * @className Code653
 * @date 2022/3/21 23:48
 */
public class Code653 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /**
         * 解题思路:将root.val放入到set中，然后遍历树，有则返回true，不存在则添加元素之后遍历子树
         */
        Set<Integer> set = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);

        }
    }
}
