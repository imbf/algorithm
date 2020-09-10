## 완주하지 못한 선수 찾기 (Hash문제)

어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 함수를 만들어라.

### 이 문제의 Key Point

- Sorting을 먼저 하고, 문자열의 길이가 작은 순서부터 반복문을 돌리니 효율성이 아주 좋아진다.

### 이 문제에서 알게 된 사실

- indexOf라는 Api는 해당 subString이 발생하는 첫번 째 index를 가르키기 때문에 접두사를 판단하기에 아주 좋은 Api이다.
- startsWith라는 Api는 지정된 인덱스에서 시작하는 이 문자열의 하위 문자열이 지정된 접두사로 시작하는지 테스트 합니다.

    
        /**
       * Returns the index within this string of the first occurrence of the
       * specified substring.
       *
       * <p>The returned index is the smallest value <i>k</i> for which:
       * <blockquote><pre>
       * this.startsWith(str, <i>k</i>)
       * </pre></blockquote>
       * If no such value of <i>k</i> exists, then {@code -1} is returned.
       *
       * @param   str   the substring to search for.
       * @return  the index of the first occurrence of the specified substring,
       *          or {@code -1} if there is no such occurrence.
       */
      public int indexOf(String str) {
          return indexOf(str, 0);
      }
