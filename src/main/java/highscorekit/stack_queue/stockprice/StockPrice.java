package highscorekit.stack_queue.stockprice;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockPrice {
    
    @Test
    public void test() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answers = {4, 3, 1, 1, 0};
        int[] results = solution(prices);
        for (int i = 0; i < answers.length; i++) {
            assertEquals(answers[i], results[i]);
        }
    }
    
    public int[] solution(int[] prices) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length ; j++) {
                cnt++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            result.add(cnt);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// 스택을 활용한 풀이
/*
public int[] solution(int[] prices) {
    Stack<Integer> beginIdxs = new Stack<>();
    int i=0;
    int[] terms = new int[prices.length];

    beginIdxs.push(i);
    for (i=1; i<prices.length; i++) {
        while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx;
        }
        beginIdxs.push(i);
    }
    while (!beginIdxs.empty()) {
        int beginIdx = beginIdxs.pop();
        terms[beginIdx] = i - beginIdx - 1;
    }

    return terms;
}
 */