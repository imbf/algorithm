## 사용한 자료구조

Heap
- 우선순위 큐를 사용해야 하는데 이 중에서 heap을 사용한다면 요소의 삽입, 삭제를 O(logn)으로 할 수 있어 시간 복잡도가 낮아진다.

## 풀이 과정

1. 모든 원소를 Heap에 저장하는 것이 안좋다고 생각 했지만, 효율성 테스트 통과를 해서 다행이다.
2. min heap의 head가 k 이상이면 break;
3. min heap의 head가 k 이하인데, heap의 size가 2 이하라면 -1 리턴
4. 뒤에서 2가지 음식을 뺴와서 섞은 음식을 만들면서 head가 k이상일 때 까지 반복문 실행

## 새로 알게된 사실

1. Min Heap을 만드는 방법 : PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
2. Max Heap을 만드는 방법 : PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

