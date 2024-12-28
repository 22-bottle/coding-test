import java.io.*;
import java.util.*;

class State {
    int nodeNum;
    int sheep;
    int wolf;
    List<Integer> adjList;
    
    public State(int n, int s, int w, List<Integer> l) {
        this.nodeNum = n;
        this.sheep = s;
        this.wolf = w;
        this.adjList = new ArrayList<>(l);
    };
    
    public State(State s) {
        this.nodeNum = s.nodeNum;
        this.sheep = s.sheep;
        this.wolf = s.wolf;
        this.adjList = new ArrayList<>(s.adjList);
    }
}

class Solution {
    static int answer = 0;
    static List<Integer>[] children;
    static Queue<State> q = new ArrayDeque<>();
    
    public int solution(int[] info, int[][] edges) {
        children = new List[info.length];
        for (int i = 0; i < info.length; i++) {
            children[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges) {
            children[edge[0]].add(edge[1]);
        }
        
        q.offer(new State(0, 1, 0, children[0]));
        while (!q.isEmpty()) {
            State cur = q.poll();
            answer = Integer.max(answer, cur.sheep);
            for (int i : cur.adjList) {
                if (info[i] == 1 && cur.sheep <= cur.wolf + 1) continue;
                State next = new State(cur);
                next.nodeNum = i;
                if (info[i] == 0) next.sheep++;
                else next.wolf++;
                next.adjList.remove(new Integer(i));
                next.adjList.addAll(children[i]);
                q.offer(next);
            }
        }
        
        return answer;
    }
}