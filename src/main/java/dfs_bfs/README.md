# Breadth First Search (BFS)

### 그래프 탐색이란

- 하나의 정점으로부터 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것

### 너비 우선 탐색(BFS)의 개념

- **BFS는 그래프 전체를 탐색하는 방법 중 하나로써 루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법입니다.**
- **시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회방법**
- 즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.
- 사용하는 경우 : 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.
- 너비 우선 탐색(BFS)이 깊이 우선 탐색(DFS)보다 좀 더 복잡하다.

### 너비 우선 탐색(BFS)의 특징

#### 장점

- 노드의수가 적고 깊이가 얕을 경우 빠르게 동작할 수 있다.
- **BFS는 재귀적으로 동작하지 않는다. Queue를 사용해서 동작한다.**
- 이 알고리즘을 구현할 때 가장 큰 차이점은, **그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다는 것이다.** (이를 검사하지 않을 경우 무한루프에 빠질 위험이 있다.)
- **BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐(Queue)를 사용한다.**
  - 즉, 선입선출(FIFO) 원칙으로 탐색
  - 일반적으로 큐를 이용해서 반복적 형태로 구현하는 것이 가장 잘 동작한다.

#### 단점

- 재귀호출의 DFS와 달리 큐에 다음에 탐색할 정점들을저장해야 하므로 저장공간이 많이 필요하다.
- 노드의 수가 늘어나면 탐색해야하는 노드 또한 많아지기에 비현실적이다.

### 너비 우선 탐색(BFS)의 과정

1. 시작 노드를 방문한다. (방문한 노드 체크)
   - 큐에 방문된 노드를 삽입(enqueue) 한다.
   - 초기 상태의 큐에는 시작 노드만이 저장
2. 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문한다.
   - 큐에서 꺼낸 노드를 방문한다.
   - 큐에서 꺼낸 노드와 인접한 노드들을 모두 방문한다.
     - 인접한 노드가 없다면 큐의 앞에서 노드를 꺼낸다
   - 큐에 방문된 노드를 삽입한다.
3. 큐가 소진될 때까지 계속한다.

### 너비 우선 탐색(BFS)의 구현

```java
class BFSGraph {
	private int V;	// V는 배열의 크기를 위해 선언
	private LinkedList<Integer> adj[];	// 인접 리스트 배열 선언
	
	BFSGraph(int v){
		V = v;
		adj = new LinkedList[v];	
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
   
	// 그래프에서  가장 자리를 추가하는 기능
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
   
	// BFS 출력하기 위해 
	void BFS(int s) {
		boolean visited[] = new boolean[V]; // 방문하지 않은 모든 Verticle 표시, 기본값 false 설정
		LinkedList<Integer> queue = new LinkedList<Integer>(); // BFS를 사용하기 위한 queue 생성
		visited[s] = true; // 현재 노드를 방문한 상태로 표시하고 큐에 추가
		queue.add(s); // 큐에 현재 노드 추가
		
		while(queue.size() != 0) { // 인접 큐가 0이 아닐 경우 반복 루프 실행
			s = queue.poll(); // 정점(head) 리턴
			System.out.print(s+" ");
			Iterator<Integer> i = adj[s].listIterator(); // 모든 인접점 구하기
			while(i.hasNext()) { // 정점에 인접점이 있는 경우 탐색
				int n= i.next();	
				if(!visited[n]) {
					visited[n] = true; // 특정 인접점에 방문 했음을 표시
					queue.add(n);	// 이 특정 인접점의 인접점을 구하기 위해서 queue에 삽입
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFSGraph g = new BFSGraph(4); // BFS 객체 생성
		g.addEdge(0, 1); // edge 추가
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Breath First Traversal "+ "(starting from vertex 2)");
		
		g.BFS(2); // 정점 2에서 시작
	}

}
```

#### **너비 우선 탐색(BFS)의 시간 복잡도** (v: 정점의 수, e: 간선의 수)

- **인접 리스트로 표현된 그래프: O(v+e)**
- **인접 행렬로 표현된 그래프: O(v^2)**
- 깊이 우선 탐색(DFS)과 마찬가지로 그래프 내에 적은 숫자의 간선만을 가지는 희소 그래프(Sparse Graph) 의 경우 인접 행렬보다 인접 리스트를 사용하는 것이 유리하다.

---

# Depth First Search (DFS)

### 그래프 탐색이란

- 하나의 정점으로부터 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것
- **DFS나 BFS모두 그래프의 모든 vertex를 탐색하려는 방법이다.**

### 깊이 우선 탐색(DFS, Depth-First Search) 개념

**루트 노드에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기(branch)를 완벽하게 탐색하는 방법**

- 미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다. **(Back Tracking)**
- **즉, 넓게(wide) 탐색하기 전에 깊게(deep)탐색하는 것이다.**
- 모든 노드를 방문하고자 하는 경우에 이 방법을 선택한다. (DFS나 BFS나 모든 노드를 방문하는 것은 마찬가지이다.)
- 깊이 우선 탐색(DFS)이 너비 우선 탐색(BFS)보다 좀 더 간단하다.
- **단순 검색 속도 자체는 깊이 우선 탐색(DFS)이 너비 우선 탐색(BFS)에 비해서 느리다.**
- 스택이나 재귀함수를 통해서 구현할 수 있는데 재귀함수가 구현이 더 간편하기 때문에 대부분 재귀함수로 구현한다.

### 깊이 우선 탐색(DFS)의 특징

- 자기 자신을 호출하는 **순환 알고리즘의 형태**를 가지고 있다.
- 전위 순회(Pre-Order Traversals)를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다.
- 이 알고리즘의 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사 해야 한다는 것이다.
  - 이를 검사하지 않을 경우 무한루프에 빠질 위험이 있다.

### 깊이 우선 탐색(DFS)의 장점

- 현재 경로상의 노드들만 기억하면 되므로, **저장 공간의 수요가 비교적 적음**
- 목표 노드가 깊은 단계에 있는 경우 해를 빨리 구할 수 있음
- 구현이 너비 우선 탐색(BFS)보다 간단함

### 깊이 우선 탐색(DFS)의 단점

- 단순 검색 속도는 너비 우선 탐색(BFS) 보다 느림
- 해가 없는 경우에 빠질 가능성이 있음
  - 사전에 임의의 깊이를 지정한 후 탐색하고, 목표 노드를 발겨하지 못할 경우 다음 경로를 탐색하도록 함
- 깊이 우선 탐색은 해를 구하면 탐색이 종료되므로, 구한 해가 최단 경로가 된다는 보장이 없음
  - 목표에 이르는 경로가 다수인 경우 구한 해가 최적이 아닐 수 있음

### 깊이 우선 탐색(DFS)의 과정

![image-20201203102902777](/Users/baejongjin/Library/Application Support/typora-user-images/image-20201203102902777.png)

1. a 노드(시작 노드)를 방문한다.
   - 방문한 노드는 방문했다고 표시한다.
2. a와 인접한 노드를 차례로 순회한다.
   - a와 인접한 노드가 없다면 종료한다.
3. a와 이웃한 노드 b를 방문했다면, a와 인접한 또 다른 노드를 방문하기 전에 b의 이웃 노드들을 전부 방문해야 한다.
   - b를 시작 정점으로 DFS를 다시 시작하여 b의 이웃 노드들을 방문한다.
4. b의 분기를 전부 완벽하게 탐색했다면 다시 a에 인접한 정점들 중에서 아직 방문이 안 된 정점을 찾는다.
   - 즉, b의 분기를 전부 완벽하게 탐색한 뒤에야 a의 다른 이웃 노드를 방문할 수 있다는 뜻이다.
   - 아직 방문이 안 된 정점이 없으면 종료한다.
   - 있으면 다시 그 정점을 시작 정점으로 DFS를 시작한다.

### 깊이 우선 탐색(DFS)의 구현 (인접 리스트 사용)

```java
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


```

### 깊이 우선 탐색(DFS)의 구현 (배열 사용)

```java
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



```



### 깊이 우선 탐색(DFS)의 시간 복잡도

- DFS는 그래프(V: 정점의 수, E: Edge의 수)의 모든 간선을 조회한다.
  - 인접 리스트로 표현된 그래프: O(N+E)
  - 인접 행렬로 표현된 그래프: O(N^2)
- 즉, 그래프 내에 적은 숫자의 간선만을 가지는 희소 그래프(Sparse Graph) 의 경우 인접 행렬보다 인접 리스트를 사용하는 것이 유리하다.
  