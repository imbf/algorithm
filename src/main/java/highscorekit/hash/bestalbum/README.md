## 베스트앨범 (Hash)

### 문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

### 필요

HashMap<String, Integer>
1. 장르별 plays의 합 필요
2. plays의 합 기준으로 장르간에 정렬 필요

HashMap<String, List<Info>>
1. 곡 별 plays 필요
2. 곡 별 index 필요
3. plays를 기준으로 장르내의 곡간에 정렬 필요

### 풀이 과정

1. 장르의 합 HashMap 생성
2. 장르의 합 HashMap 정렬
3. 장르별 index와 plays가 들어간 ArrayList 생성 
4. 장르별 ArrayList를 Plays 기준으로 정렬
5. 정렬된 장르의 합 HashMap 기준으로 장르별 ArrayList에서 최대 2개의 index씩 꺼내와서 추가.
6. ArrayList -> Array 

### 이 문제를 풀면서 새로 알게된 사실

- Stream<T> limit(long maxSize)라는 Apis는 함수는 길이가 maxSize 이하로 잘린 해당 스트림의 요소로 이루어진 스트림을 리턴한다.
- <R> Stream<R> map(Function<? super T, ? extends R> mapper)라는 api는 해당 스트림의 Element에 주어진 함수를 적용한 결과로 구성된 스트림을 리턴한다.
- HashMap<K, V>의 V값에 Object를 넣는다면 Object를 상속하는 즉, 모든 객체를 Value로 넣을 수 있다.

