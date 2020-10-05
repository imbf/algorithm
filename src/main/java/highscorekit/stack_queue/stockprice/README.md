## 주식가격(스택/큐)

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

### 풀이 과정

**반복문을 활용한 풀이**

1. 배열의 원소 값을 비교해서 각각 원소의 횟수를 늘려줘야만 했다.
2. ArrayList<Integer>를 new Int[]로 바꾸어야만 했다.

**스택을 활용한 풀이**
1. 각 index 마다 값을 계산하여 다음 index 값보다 작은지 비교
2. 작다면 비교한 index 순서를 기점으로 하여 자신보다 작은 index의 가격이 떨어지지 않는 기간 산출
3. 마지막으로 산출되지 않은 index의 가격이 떨어지지 않는 기간 산출

### 이 문제를 풀면서 새로 알게된 사실

- streamObject.**mapToInt(ToIntFunction<? super T> mapper)** : 스트림의 원소에 주어진 함수를 적용한 결과로 구성된 IntStream을 반환합니다.
- **IntStreamObject.toArray()** : IntStream의 원소를 포함하는 int[] 배열을 리턴합니다.

> IntStream이란 순차 및 병렬 집계 작업을 지원하는 primitive int 값 요소의 시퀀스 입니다.
>
> sorted, sum, count, ... 등의 작업을 지원합니다.
