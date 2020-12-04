package dfs_bfs;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSExample1 {
    
    @Test
    public void test() {
        Graph g = new Graph(4);
    
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    
        g.DFS(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        g.DFS();
    }
    
    private class Graph { // 인접 리스트를 이용한 방향성 있는 그래프 클래스
        private int V;   // 노드의 개수
        private LinkedList<Integer> adj[]; // 인접 리스트
        
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }
        
        void addEdge(int v, int w) { // 노드를 연결 v->w
            adj[v].add(w);
        }
        
        void DFSUtil(int v, boolean visited[]) {
            visited[v] = true; // 현재 노드를 방문한 것으로 표시
            System.out.print(v + " "); // 정점의 값 출력
            
            Iterator<Integer> i = adj[v].listIterator(); // 방문한 노드와 인접한 모든 노드를 가져온다.
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
                    DFSUtil(n, visited); // 순환 호출
            }
        }
        
        void DFS(int v) { // 주어진 노드를 시작 노드로 DFS 탐색
            boolean visited[] = new boolean[V]; // 노드의 방문 여부 판단 (초깃값: false)
            DFSUtil(v, visited); // v를 시작 노드로 DFSUtil 순환 호출
        }
        
        void DFS() { // DFS 탐색
            boolean visited[] = new boolean[V]; // 노드의 방문 여부 판단 (초깃값: false)
            
            for (int i = 0; i < V; ++i) { // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
                if (visited[i] == false)
                    DFSUtil(i, visited);
            }
        }
    }
}

