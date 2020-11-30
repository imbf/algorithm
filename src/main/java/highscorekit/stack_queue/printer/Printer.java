package highscorekit.stack_queue.printer;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Printer {
    
    @Test
    public void test() {
        int[] priorities1 = {2, 1, 3, 2};
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        
        assertEquals(solution(priorities1, 2), 1);
        assertEquals(solution(priorities2, 0), 5);
    }
    
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i], i));
        }
        
        while (true) {
            int maxInt = queue.stream().mapToInt(Document::getPriority).max().orElseGet(() -> 0);
            Document poll = queue.poll();
            if (poll.getPriority() == maxInt) {
                answer++;
                if (poll.isSameLocation(location)) {
                    break;
                }
            } else {
                queue.add(poll);
            }
        }
        return answer;
    }
}

class Document {
    private int priority;
    private int location;
    
    public Document(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
    
    public boolean isSameLocation(int location) {
        return this.location == location;
    }
    
    public int getPriority() {
        return priority;
    }
}

/*
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(priorities[i], i));
        }
        while (true) {
            Document poll = queue.poll();
            int maxInt = queue.stream().mapToInt(Document::getPriority).max().orElseGet(() -> 0);
            if (poll.getPriority() >= maxInt) {
                answer++;
                if (poll.isSameLocation(location)) {
                    break;
                }
            } else {
                queue.offer(poll);
            }
            
        }
        return answer;
    }
    */


/*
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities); // 우선순위 순서로 오름차순 정렬
        int size = priorities.length-1; // 우선 순위의 원소 개수 -1

        // Queue가 Empty가 아닐 떄 반복문
        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){ // i가 최대값과 같다면 answer++
                answer++;
                l--;                            // 인덱스는 감소되고
                if(l <0)                        // 인덱스가 0이하가 되면 break
                    break;
            }else{
                que.add(i);                     // i가 최대값과 다르다면
                l--;                            // 인덱스는 감소되고
                if(l<0)                         // 인덱스가 0이하가 되면 다시 인덱스는 마지막으로 돌아간다.
                    l=que.size()-1;
            }
        }

        return answer;          //
    }
}
*/