## 다리를 지나는 트 (스택/큐)

트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.

## 풀이 과정
**나의 풀이**
1. Truck 클래스를 만들어, 현재 위치와 무게를 추상화 할 수 있는 객체를 만든다.
2. PassedTruck이 truck의 개수와 동일할 때 이 프로그램을 끝낸다.
3. 다리가 견딜 수 있는 무게보다 작다면 다리를 건너고 있는 트럭의 List에 트럭을 계속 추가한다.
4. 다리를 건너는 트럭 모두의 position을 증가한다.
5. 맨 앞의 트럭이 다리에 끝이라면 다리를 건너는 트럭의 리스트에서 제거하고 다리를 다 건넌 트럭의 개수를 하나 증가시킨다.
6. 위의 모든 과정에서 time을 기록하고 이를 결과값으로 반환한다.

## 이 문제를 풀면서 새로 알게된 사실

**Method Reference**

이미 구현하고자 하는 람다식 자체가 구현되어 있는 경우 메서드 참조를 이용하면 기존 메서드 구현으로 람다 표현식을 만들 수 있다.
매번 람다 표현식을 만드는 것보다 기존 메서드 구현을 람다식으로 사용하면 매우 편리하다.


- 메소드 레퍼런스에는 4가지의 경우가 있다.
    1. Static Method Reference
        - (Lamda)  (args) -> Class.staticMethod(args)
        - (Reference)  Class::staticMethod 
    2. Instance Method Reference of a particular object.
        - (Lamda)  (obj, args) -> obj.instanceMethod(args)
        - (Reference)  ObjectType::instanceMethod
    3. Instance Method Reference of an arbitrary object of a particular type.
        - (Lamda)  (args) -> obj.instanceMethod(args)
        - (Reference)  obj.instanceMethod
    4. Constructor Reference.
        - (Lamda)  (args) -> new ClassName(args)
        - (Reference)  ClassName::new

**Queue**
- 선형 리스트(Linear List)에서 한쪽에서는 삽입이 이루어지고 다른 쪽에서는 삭제가 이루어지도록 구성한 자료구조
- FIFO 방식으로 처리
- Queue의 용도
    - 순서를 기다리는 류의 프로세스 처리
    - 운영체제의 작업 스케줄링


**Deque**
- 삽입과 삭제가 양쪽 끝에서 모두 발생할 수 있는 자료구조
- Stack과 Queue의 장점만 따서 구성되어 있음

**LinkedList in Java**
- List의 특성과, Deque의 특성, LinkedList의 특성을 모두 가진 자료구조!!
- 매우 유용하니 이를 잘 활용하면 아주 좋은 코드를 짤 수 있다.
