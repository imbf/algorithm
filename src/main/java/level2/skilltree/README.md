### 풀이 과정

**사용한 자료 구조** : LikedList
- 왜 사용했는지는 모르겠으나, Queue, Dequeue, Stack의 구현체이기 때문에 그냥 사용했다.

1. skill과 skill_tree들을 모두 LinkedList<Character>에 저장
2. 올바른 순서인지 비교
    - 2-1. 올바른 순서일 경우
        - 2-1-1. skill_tree의 첫 번째 원소가 skill의 첫 번째 원소와 동일할 경우 skillTree와 skill의 맨 앞 글자 삭제
        - 2-1-2. skill_tree의 첫 번째 원소가 skill의 첫 번째 원소와 다르지만 순서를 어기지 않는 경우 skillTree의 첫 번째 완소만 삭제
    - 2-2. 올바른 순서가 아닌경우
        - 2-2-1. skill_tree의 첫 번째 원소가 skill의 순서를 어기는 경우 해당 반복문 break 후 다음 skill_tree 탐색
    - 2-3. skill_tree의 원소가 모두 없어지거나, skill의 원소가 모두 없어지는 경우 해당 skill_tree는 순서를 어기지 않음으로 answer++시키고 다음 skill_tree 검색
    
### 새로 알게 된 사실

- LinkedList를 사용하면서 다양한 API를 사용할 수 잇었다.
    - add(E e) : 특정 element를 list의 마지막에 추가
    - poll() : 리스트의 해드 즉, 첫 번째 원소를 제거 후 리턴 (Stack의 pop()과 동일)
    - peek() : 리스트의 헤드 즉, 첫 번째 원소를 제거하지 않고 리턴
        - peekLast는 왜 존재하는지 알겠는데, peekFirst()는 내부 코드도 똑같은데 왜 넣어놨을 까??? 통일성? 가독성? 흠.. 가독성 이라고 하는게 좀 더 맞을 것 같다.
        - 명세도 똑같군.. <p>This method is equivalent to {@link #peekFirst()}.
        
- for 구문 돌리기 귀찮아서 stream.anyMatch() 를 사용 했는데 좋은 것 같다.
