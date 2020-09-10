package highscorekit.hash.notfinishplayer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotFinishPlayer {
    
    @Test
    public void test() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        
        assertEquals(solution(participant, completion), "leo");
    }
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.stream(participant).forEach(p -> {
            if (hashMap.containsKey(p)) {
                hashMap.put(p, hashMap.get(p) + 1);
            } else {
                hashMap.put(p, 1);
            }
        });
        for (String s : completion) {
            hashMap.put(s, hashMap.get(s) - 1);
        }
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}

//다른 인기 풀이
/*

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
*/