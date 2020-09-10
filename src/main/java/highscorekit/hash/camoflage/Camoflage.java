package highscorekit.hash.camoflage;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Camoflage {
    
    @Test
    public void test() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        assertEquals(solution(clothes), 5);
        
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        assertEquals(solution(clothes2), 3);
    }
    
//    public int solution(String[][] clothes) {
//        int answer = 1;
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        for (String[] clothe : clothes) {
//            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1], 0) + 1);
//        }
//        for (String key : hashMap.keySet()) {
//            answer *= (hashMap.get(key) + 1);
//        }
//        return answer - 1;
//    }
    
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}


