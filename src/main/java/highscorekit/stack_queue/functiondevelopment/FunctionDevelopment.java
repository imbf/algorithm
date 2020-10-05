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
        Stack<Info> stack = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(new Info(progresses[i], speeds[i]));
        }
        
        for (int i = 1; !stack.isEmpty(); i++) {
            int cnt = 0;
            while (!stack.isEmpty() && stack.peek().isDeploy(i)) {
                stack.pop();
                cnt++;
            }
            if (cnt != 0) // 이 분기문을 없애고 마지막에 filter로 0인 원소를 필터링 해도 좋다.
                result.add(cnt);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 가장 인기있는 풀
    /*
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
     */
}

class Info {
    private int progress;
    private int speed;
    
    public Info(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
    
    public boolean isDeploy(int days) {
        return (progress + days * speed) >= 100;
    }
}
