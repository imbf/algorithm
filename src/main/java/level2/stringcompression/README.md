### 사용한 자료구조

**StringBuffer**
- 하나의 문자열만 여러번 연산한다면 String을 쓰는 것 보다, StringBuffer를 쓰는것이 훨씬 속도가 빠르다.
- String은 immutable하기 때문에 연산시 매번 새로운 객체를 만들기 때문에 속도가 비교적 느리다.

### 풀이 방법

1. buffer와, compressedBuffer 생성
2. 1번째 부터 (string.length()+1)/2 까지 나눌 문자열의 개수를 지정한다.
3. buffer의 크기가 i보다 작으면 buffer의 남은 크기를 compressedBuffer에 저장한다.
4. buffer의 크기가 i보다 크면 buffer의 앞 i개의 문자열을 비교해서 compressedBuffer에 변환한다.
5. compressedBuffer의 계산이 끝나면 length를 answers에 저장하고 마지막으로 최소값을 구한다.
 
### 새로 알게 된 사실

- StringBuffer.delete(int start, int end)는 start부터 end-1까지의 문자열을 제거한 후 남은 문자열을 리턴해주는 메소드이다.
- 스트림을 잘 사용하니 확실히 연산이 매우 편해졌다.

### 문자열 관련 클래스

- **String**: 문자열 연산이 적고 멀티쓰레드 환경일 경우 (Thread-Safe)
- **StringBuffer**: 문자열 연산이 많고 멀티쓰레드 환경일 경우 (Thread-Safe) 
- **StringBuffer**: 문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우 (Thread-Unsafe)
