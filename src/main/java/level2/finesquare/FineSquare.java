package level2.finesquare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FineSquare {
    
    @Test
    public void test() {
        int w = 8;
        int h = 12;
        long result = solution(8, 12);
        assertEquals(result, 80);
    }
    
    public long solution(int w, int h) {
        long answer = (long) w * h;
        int max = Integer.max(w, h);
        int min = Integer.min(w, h);
        answer = answer - max;
        
        for (int y = 1; y <= min; y++) {
            long k = ((long) max * y) % min;
            if (k != 0) {
                answer--;
            }
        }
        return answer;
    }
}
