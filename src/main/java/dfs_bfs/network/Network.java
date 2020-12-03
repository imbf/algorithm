package dfs_bfs.network;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Network {
    
    @Test
    public void test() {
        int n = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        assertEquals(solution(n, computers1), 2);
        assertEquals(solution(n, computers2), 1);
    }
    
    public int solution(int n, int[][] computers) {
        List<List<Integer>> lists = new LinkedList<>();
        
        Graph graph = new Graph(n);
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (computers[i][j] == 1) {
                    graph.addEdge(i, j);
                    graph.addEdge(j, i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (List<Integer> list : lists) {
                for (Integer integer : list) {
                    if (integer == i) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1)
                    break;
            }
            if (flag == 0) {
                lists.add(graph.bfs(i));
            }
        }
        return lists.size();
    }
    /*
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n]; // 그래프의 정점 방문 여부를 체크하는 배열
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {   // i번째 정점에 방문하지 않았다면
                dfs(computers, chk, i); // i번째 정점을 시작으로 dfs
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;  // i번째 정점에 방문했다는 표시
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) { // 방문하지 않은 i번째 정점이자, i번째 정점과 연결된 정점 탐색
                dfs(computers, chk, i); //재귀
            }
        }
    }
    */
}

class Graph {
    private int n;
    private LinkedList<Integer> adj[];
    
    public Graph(int v) {
        n = v;
        adj = new LinkedList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
    
    public List<Integer> bfs(int s) {
        List<Integer> network = new ArrayList<>();
        boolean visited[] = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        
        visited[s] = true;
        queue.add(s);
        network.add(s);
        
        while (queue.size() != 0) {
            Integer poll = queue.poll();
            Iterator<Integer> i = adj[poll].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    network.add(n);
                }
            }
        }
        return network;
    }
}
