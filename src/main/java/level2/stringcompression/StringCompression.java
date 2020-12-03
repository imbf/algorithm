package level2.stringcompression;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompression {
    
    @Test
    public void test() {
        assertEquals(solution("aabbaccc"), 7);
        assertEquals(solution("ababcdcdababcdcd"), 9);
        assertEquals(solution("abcabcdede"), 8);
        assertEquals(solution("abcabcabcabcdededededede"), 14);
        assertEquals(solution("xababcdcdababcdcd"), 17);
    }
    
    public int solution(String s) {
        List<Integer> answers = new ArrayList<>();
        for (int i = 1; i <= (s.length() + 1) / 2; i++) {
            StringBuffer buffer = new StringBuffer(s);
            StringBuffer compressedBuffer = new StringBuffer();
            while (true) {
                int number = 1;
                if (buffer.length() < i) {
                    compressedBuffer.append(buffer.toString());
                    break;
                }
                
                String deletedString = buffer.substring(0, i);
                buffer.delete(0, i);
                while (buffer.length() >= i && deletedString.equals(buffer.substring(0, i))) {
                    buffer.delete(0, i);
                    number++;
                }
                
                if (number != 1) {
                    compressedBuffer.append(number);
                }
                
                compressedBuffer.append(deletedString);
            }
            answers.add(compressedBuffer.length());
        }
        
        return answers.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
    
    /*
    public int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat+1);
    }
     */
}
