### 사용한 자료 구조

**StringBuffer**
- 매번 String 객체가 생기는 것을 방지하기 위해 StringBuffer를 사용했다.

##  풀이 과정
1. num이라는 배열을 선언해 4, 1, 2 순서대로 원소가 들어있게 한다.
2. 맨 뒷자리부터 자리수를 변환한다.
3. String의 역순을 리턴한다.
    
### 새로 알게 된 사실

- StringBuffer (mutable class)
    - String 클래스와 다르게 자유롭게 인스턴스(char[])의 값을 변경할 수 잇는 문자열 클래스이다.
    - stringBuffer.append(char c): StringBuffer에서 관리하는 문자열 끝에 인자 c를 추가한다.
    - stringBuffer.reverse(): Character의 순서가 역순으로 바뀐다.
        - 새로운 String이 생성되는 것이 아니라 stringBuffer 객체가 관리하는 chars[]의 값이 역순으로 바뀐다.