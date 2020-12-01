package heap.morehot;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoreHot {
    
    @Test
    public void test() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        assertEquals(solution(scoville, k), 2);
    }
    
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
                priorityQueue.add(scoville[i]);
        }
        
        while (true) {
            if (priorityQueue.peek() >= k) {
                break;
            }
            if (priorityQueue.size() < 2) {
                return -1;
            }
            
            int min = priorityQueue.poll();
            int secondMin = priorityQueue.poll();
            priorityQueue.add(min + secondMin * 2);
            answer++;
        }
        
        return answer;
    }
}
