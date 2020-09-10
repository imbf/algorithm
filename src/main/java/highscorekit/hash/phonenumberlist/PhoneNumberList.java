package highscorekit.hash.phonenumberlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberList {
    
    @Test
    public void test() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        assertEquals(solution(phone_book), false);
        
        String[] phone_book2 = {"123", "456", "789"};
        assertEquals(solution(phone_book2), true);
    }
    
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].indexOf(phone_book[i]) == 0)
                    return false;
            }
        }
        return true;
    }
}
