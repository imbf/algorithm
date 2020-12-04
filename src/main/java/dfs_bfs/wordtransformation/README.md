## 사용한 알고리즘

**Depth First Search(DFS)**
- 

## 풀이 방법

**전체 로직**
1. begin과 words[]를 하나의 배열로 간주해 비슷한 단어끼리 양방향 mapping 해준다.
2. DFS로 branch별 answer를 우선순위 큐(min heap)에 저장한다.
3. head의 값을 꺼내 return 한다. 존재하지 않으면 0 리턴

**DFS 로직**
- dfs(int v, int answer, Queue<Integer> pathLengthQueue, String[] words, String target)
    - 현재 dfs 를 실행할 vertex가 v이다.
    - 현재까지 거쳐간 v의 개수를 answer에 저장
    - target을 찾았을 때 현재 answer의 값을 pathLengthQueue에 저장한다.
    - words를 통해 비교할 대상 판
    
1. dfs에 들어온 정점의 visited[v]를 true로 바꾼다.
2. v의 인접행렬을 구한다.
3. 인접 행렬이 존재한다면 첫 번째 요소를 next라고 지정한다.
4. words[next]가 target과 동일하다면 answer +1을 우선순위 큐에 저장한다.
5. next가 방문되지 않았다면, next의 인접행렬을 dfs로 탐색한다. (answer값 1증가)

## 깨달은 사실

- 생각보다 DFS가 어렵지 않다는 것을 느꼈다.
- 문제에서 node간에 순서가 정해져 있지 않고 우리가 자율적으로 탐색한다면 vertex간에 양방향으로 edge를 맵핑해주자.
- 전역 변수를 자주 사용해도 아주 좋을 것 같다.




