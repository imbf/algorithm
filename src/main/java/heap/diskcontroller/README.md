## 사용한 자료구조

**Heap**
- 매번 max 값을 가져오기에 시간 복잡도가 높아지니, O(logn)을 위해서 우선순위 큐를 사용했다.
- 특정 index를 탐색할 이유가 없기 때문에 queue를 사용해도 무방하다고 생각했다.
- peek, offer, poll API 모두 너무 좋다.


## 이 문제를 통해서 새로 알게 된 사실

- PriorityQueue를 사용하기 앞서 충족해야되는 조건이 있다.
    -PriorityQueue 객체 생성시 생성자에 Comparator 객체를 넣어 주는 경우
    -PriorityQueue 객체가 관리하는 Object 자체가 Comparable 인터페이스를 구현하는 객체인 경우     
    
- Comparator vs Comparable
    - Comparator는 2개의 객체를 사용해서 Collection을 정렬한다.
    - Comparable은 this와 하나의 객체를 비교해서 Collection을 정렬한다.
    
    