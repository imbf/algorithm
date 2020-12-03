package dfs_bfs.targetnumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TargetNumber {
    
    private Integer answer = 0;
    
    @Test
    public void test() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        
        assertEquals(solution(numbers, target), 5);
    }
    
    public int solution(int[] numbers, int target) {
        int sum = 0;
        search(numbers, sum, 0, target);
        return answer;
    }
    
    private void search(int[] numbers, int sum, int idx, int target) {
        if (idx == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        search(numbers, sum + numbers[idx], idx + 1, target);
        search(numbers, sum - numbers[idx], idx + 1, target);
    }
}
/*
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) { // n이 length와 길이가 동일
            if(sum == target) { // sum이 target과 동일하면 1리턴
                return 1;
            }
            return 0;
        }
        // dfs로 n+1번째 검사한다. 하나는 sum + numbers[n], 다른 하나는 sum - numbers[n]으로 dfs 태운다.
        // 마지막 return 문장이 정말 기가 맥힌 것 같다. return 을 0또는 1로하는 부분이 제일 기가 맥히다.
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
        
    }
}
 */




