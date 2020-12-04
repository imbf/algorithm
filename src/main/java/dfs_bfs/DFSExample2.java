package dfs_bfs;


import org.junit.jupiter.api.Test;

public class DFSExample2 {
    
    @Test
    public void test() {
        Graph g = new Graph(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.dfs(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        g.dfs();
    }


    private class Graph {
        int v;
        int array[][];
        boolean[] visited;

        Graph(int v) {
            this.v = v;
            array = new int[this.v][];
            visited = new boolean[this.v];
            for(int i = 0; i < v; i++) {
                array[i] = new int[v];
            }
        }

        void addEdge(int v, int w) {
            array[v][w] = 1;
        }

        void dfs(int v) {
            
            visited[v] = true;
            System.out.print(v + " ");

            for(int i = 0 ; i < array[v].length; i++) {
                if (array[v][i] == 1 && !visited[i])
                    dfs(i);
            }
        }
        
        void dfs() {
            for (int i = 0; i < array.length; i++) {
                visited[i] = true;
                System.out.print(i + " ");
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == 1 && !visited[j])
                        dfs(j);
                }
            }
        }
    }
}


