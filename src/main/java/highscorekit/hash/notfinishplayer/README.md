## 완주하지 못한 선수 찾기 (Hash문제)

참가자와 완주자를 비교해서 1명의 완주하지 못한사람의 이름을 출력해야 한다.

참가자의 이름은 중복될 수 있다는 점을 잘 고려해서 설계를 해야만 했다.

어떻게 설계를 할 것인가에 앞서 Hash가 무엇인지 알아보자!

### 해시(Hash)

해시란 데이터를 다루는 기법 중에 하나로 **검색과 저장이 아주 빠르게** 진행된다. 아주 빠르게 진행될 수 있는 이유는 데이터를 검색할 때
사용할 key와 실제 데이터 값이 (value가) 한 쌍으로 존재하고, key값이 배열의 인덱스로 변환되기 때문에 검색과 저장의 **평균적인 시간 복잡도가 O(1)에 수렴**하게 된다.

### HashMap vs HashTable

https://www.geeksforgeeks.org/differences-between-hashmap-and-hashtable-in-java/

HashTable은 잘 안쓸 것 같고, HashMap을 자주 쓸 것 같다.

null에 대한 차이도 있지만, HashTable은 동기화가 제공되고(Thread safe), HashMap은 동기화가 제공되지 않는게(non-Thread Safe) 가장 큰 차이이다.

### Map(Map) in Java

Key에게 Value를 맵핑하는 명세이다. Map은 중복된 키를 포함할 수 없고, 각 key는 많아봐야 하나의 value를 가질 수 있다.

이 인터페이스는 Dictionary 클래스를 대신합니다. Dictonary 클래스는 abstract 클래스입니다.


### 이 문제를 푸는데 생각한 기발한 방법!!

- HashMap에서 keySet을 return하는 API가 존재하는데, 이를 활용하면 hashMap이라도 완전탐색을 할 수 있다.
- HashMap에서 getOrDefault(Object key, V defaultValue) 도 존재하기 때문에 이를 활용해도 더 짧은 코드를 만들 수 있다.

### 오늘 형들에게 얻은 알고리즘 꿀팁

- for문을 이중으로 쓰면 효율성이 즉, 시간복잡도가 높아진다.!!!! 2중 for문보다, for문을 2번쓸 수 있다면 훨씬 좋다.