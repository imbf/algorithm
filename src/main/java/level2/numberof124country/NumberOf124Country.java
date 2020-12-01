package level2.numberof124country;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOf124Country {
    @Test
    public void test() {
        assertEquals(solution(1), "1");
        assertEquals(solution(2), "2");
        assertEquals(solution(3), "4");
        assertEquals(solution(4), "11");
        assertEquals(solution(10), "41");
    }
    
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        StringBuffer answer = new StringBuffer();
        while (n > 0) {
            answer.append(num[n % 3]);
            n = (n - 1) / 3;
        }
        
        return answer.reverse().toString();
    }
}
