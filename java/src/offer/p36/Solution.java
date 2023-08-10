package offer.p36;


import offer.definitions.Node;

//https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        inOrder(root);
        //此时遍历完毕，pre已经指向了尾节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    void inOrder(Node current) {
        if (current == null) return;

        inOrder(current.left);

        if (pre != null) pre.right = current;
        else head = current; //注意head不是根节点，而应该是最左边的节点，是需要寻找的。
        current.left = pre;
        pre = current;

        inOrder(current.right);

    }

}