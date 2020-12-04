package dfs_bfs.wordtransformation;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTransformation {
    
    @Test
    public void test() {
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        String begin3 = "hit";
        String target3 = "cog";
        String[] words3 = {"dot", "dog", "cit", "cot", "cog", "hot", "bog", "zog"};
        
//        assertEquals(solution(begin1, target1, words1), 4);
//        assertEquals(solution(begin2, target2, words2), 0);
        assertEquals(solution(begin3, target3, words3), 3);
    }
    
    public int solution(String begin, String target, String[] words) {
        String[] newWords = new String[words.length + 1];
        Graph graph = new Graph(newWords.length);
        newWords[0] = begin;
        for (int i = 1; i < newWords.length; i++) {
            newWords[i] = words[i - 1];
        }
        
        
        for (int i = 0; i < newWords.length; i++) {
            for (int j = 0; j < newWords.length; j++) {
                if (isSimilarChar(newWords[i], newWords[j])) {
                    graph.addEdge(i, j);
                }
            }
        }
        
        return graph.optimizePathLength(0, target, newWords);
    }
    
    private boolean isSimilarChar(String first, String second) {
        int result = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == second.charAt(i)) {
                result++;
            }
        }
        if (result == first.length() - 1) {
            return true;
        }
        return false;
    }
    
    private class Graph {
        private int V;
        private LinkedList<Integer>[] adjs;
        private boolean[] visited;
        
        Graph(int v) {
            V = v;
            adjs = new LinkedList[V];
            visited = new boolean[V];
            for (int i = 0; i < adjs.length; i++) {
                adjs[i] = new LinkedList<>();
            }
        }
        
        void addEdge(int x, int y) {
            adjs[x].add(y);
        }
        
        int optimizePathLength(int v, String target, String[] words) {
            Queue<Integer> pathLengthQueue = new PriorityQueue<>();
            dfs(v, 0, pathLengthQueue, words, target);
            Integer poll = pathLengthQueue.poll();
            return poll == null ? 0 : poll;
        }
        
        void dfs(int v, int answer, Queue<Integer> pathLengthQueue, String[] words, String target) {
            visited[v] = true;
            
            Iterator<Integer> i = adjs[v].listIterator();
            while (i.hasNext()) {
                int next = i.next();
                if (words[next].equals(target)) {
                    pathLengthQueue.offer(answer + 1);
                    break;
                }
                
                if (!visited[next])
                    dfs(next, answer + 1, pathLengthQueue, words, target);
            }
        }
        
/*        int optimizePathLength(int v, String target, String[] words) {
            Queue<Integer> pathLengthQueue = new PriorityQueue<>();
            dfs(v, 0, pathLengthQueue, words, target);
            Integer poll = pathLengthQueue.poll();
            return poll == null ? 0 : poll;
        }
        
        void dfs(int v, int answer, Queue<Integer> pathLengthQueue, String[] words, String target) {
            visited[v] = true;
            
            Iterator<Integer> i = adjs[v].listIterator();
            while (i.hasNext()) {
                int next = i.next();
                if (words[next].equals(target)) {
                    pathLengthQueue.offer(answer + 1);
                    break;
                }
                
                if (!visited[next])
                    dfs(next, answer + 1, pathLengthQueue, words, target);
            }
        }*/
    }
}

/*
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Node { // Node 클래스 정의
        String next;
        int edge;

        public Node(String next, int edge) { // Node 클래스 생성자
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;
        Queue<Node> q = new LinkedList<>(); // BFS를 위한 배열
        boolean[] visit = new boolean[n];  // 방문을 검사하기 위한 visit 배열 생성 (원소 모두를 false로 초기화)
        q.add(new Node(begin, 0));  // 첫 번째 노드를 큐에 추가 (이게 항상 예외였다.)

        while(!q.isEmpty()) {   // 큐가 비었다면 반복문 종료
            Node cur = q.poll();    // 큐의 head를 꺼낸다.
            if (cur.next.equals(target)) { // 큐의 head 값이 target과 동일하다면
                ans = cur.edge; // 엣지의 값을 answer에 대입한다.
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) { // i가 방문하지 않았고,  words[i]가 cur과 비슷하다면
                    visit[i] = true;                           // visit[i]의 값은 true로 바꾸어준다.
                    q.add(new Node(words[i], cur.edge + 1));   // 추후 큐에 Node를 만들어서 삽입한다.
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }
}
 */

