package heap.diskcontroller;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskController {
    @Test
    public void test() {
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//        assertEquals(solution(jobs), 9);
        
        int[][] jobs2 = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
        assertEquals(solution(jobs2), 72);
        
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        Queue<Job> minStartTimeHeap = new PriorityQueue<>((o1, o2) -> o1.getStartTime() - o2.getStartTime());
        Queue<Job> minTaskTimeHeap = new PriorityQueue<>((o1, o2) -> o1.getTaskTime() - o2.getTaskTime());
    
        for (int i = 0; i < jobs.length; i++) {
            minStartTimeHeap.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        
        while (!minTaskTimeHeap.isEmpty() || !minStartTimeHeap.isEmpty()) {
            while (!minStartTimeHeap.isEmpty() && minStartTimeHeap.peek().isStart(time)) {
                minTaskTimeHeap.offer(minStartTimeHeap.poll());
            }
            
            if (minTaskTimeHeap.isEmpty()) {
                time = minStartTimeHeap.peek().getStartTime();
            } else {
                Job job = minTaskTimeHeap.poll();
                answer += time - job.getStartTime() + job.getTaskTime();
                time += job.getTaskTime();
            }
        }
        
        answer = answer / jobs.length;
        return answer;
    }
}

class Job {
    private int startTime;
    private int taskTime;
    
    public Job(int startTime, int taskTime) {
        this.startTime = startTime;
        this.taskTime = taskTime;
    }
    
    public boolean isStart(int time) {
        return startTime <= time;
    }
    
    public int getStartTime() {
        return startTime;
    }
    
    public int getTaskTime() {
        return taskTime;
    }
}
