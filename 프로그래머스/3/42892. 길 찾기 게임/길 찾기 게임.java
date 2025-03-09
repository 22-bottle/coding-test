import java.io.*;
import java.util.*;

class Node {
    int idx, x, y;
    Node parent, left, right;
    
    public Node(int[] info) {
        this.idx = info[0];
        this.x = info[1];
        this.y = info[2];
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1[2] == o2[2]) return o1[1] - o2[1];
        return o2[2] - o1[2];
    });
    static int n = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        for (int i = 0; i < nodeinfo.length; i++) {
            pq.offer(new int[] {i + 1, nodeinfo[i][0], nodeinfo[i][1]});
        }
        
        int[] rootInfo = pq.poll();
        Node root = new Node(rootInfo);
        while (!pq.isEmpty()) {
            update(root, new Node(pq.poll()));
        }
        
        int[][] answer = new int[2][nodeinfo.length];
        preorder(root, answer);
        postorder(root, answer);
        return answer;
    }
    
    public void postorder(Node node, int[][] answer) {
        if (node == null) return;
        postorder(node.left, answer);
        postorder(node.right, answer);
        answer[1][n++] = node.idx;
    }
    
    public void preorder(Node root, int[][] answer) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            answer[0][count++] = cur.idx;
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }
    
    public void update(Node root, Node cur) {
        Node next = root;
        while (true) {
            if (next.x > cur.x) {
                if (next.left == null) {
                    next.left = cur;
                    cur.parent = next;
                    break;
                }
                next = next.left;
            } else {
                if (next.right == null) {
                    next.right = cur;
                    cur.parent = next;
                    break;
                }
                next = next.right;
            }
        }
    }
}