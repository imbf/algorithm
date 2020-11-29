package highscorekit.stack_queue.functiondevelopment;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionDevelopment {
    
    @Test
    public void test() {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] return1 = {2, 1};
        
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] return2 = {1, 3, 2};
        
        int[] result1 = solution(progresses1, speeds1);
        int[] result2 = solution(progresses2, speeds2);
        
        for (int i = 0; i < result1.length; i++) {
            assertEquals(result1[i], return1[i]);
        }
        for (int i = 0; i < result2.length; i++) {
            assertEquals(result2[i], return2[i]);
        }
        
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Task> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Task(progresses[i], speeds[i]));
        }
        
        for (int i = 1; !queue.isEmpty(); i++) {
            int cnt = 0;
            while (!queue.isEmpty() && queue.peek().isDeploy(i)) {
                queue.poll();
                cnt++;
            }
            result.add(cnt);
        }
        
        return result.stream().filter(i -> i != 0).mapToInt(Integer::intValue).toArray();
    }
}

class Task {
    private int progress;
    private int speed;
    
    public Task(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
    
    public boolean isDeploy(int days) {
        return (progress + days * speed) >= 100;
    }
}
