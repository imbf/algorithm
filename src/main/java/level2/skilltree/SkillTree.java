package level2.skilltree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTree {
    
    @Test
    public void test() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int solution = solution(skill, skill_trees);
        
        assertEquals(solution, 2);
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            LinkedList<Character> skillChars = new LinkedList<>();
            LinkedList<Character> skillTreeChars = new LinkedList<>();
            for (int i = 0; i < skill.length(); i++) {
                skillChars.add(skill.charAt(i));
            }
            for (int i = 0; i < skill_tree.length(); i++) {
                skillTreeChars.add(skill_tree.charAt(i));
            }
            
            while (true) {
                if (isRightOrder(skillChars, skillTreeChars.peek())) {
                    skillTreeChars.poll();
                } else {
                    break;
                }
                
                if (skillChars.isEmpty() || skillTreeChars.isEmpty()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
    
    private boolean isRightOrder(LinkedList<Character> skillChars, char character) {
        if (skillChars.peek() == character) {
            skillChars.poll();
            return true;
        }
        
        Character[] characters = skillChars.toArray(new Character[]{});
        if (Arrays.stream(characters).anyMatch(c -> c == character) == true) {
            return false;
        }
        
        return true;
    }
}

/* 정규표현식 풀이를 제외한 다른 사람의 풀이
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            int learningIdx = 0;
            boolean isAble = true;
            for (char curSkill : skillTree.toCharArray()) {
                int skillIdx = skill.indexOf(curSkill); // 특정한 charcter에 대한 첫 번째 위치를 나타낸다.
                if (skillIdx == -1) // skill에 curSkill이 없을 경우
                    continue;
                // skillIdx와 learningIdx가 동일하면 즉, 검색한 값이 현재 스킬트리로 배워야하는 것이라면
                else if (skillIdx == learningIdx)
                    learningIdx++;  // learningIdx 즉, skillTree에서 배워야 하는 스킬을 다음 단계로 넘긴다.
                else {  // 만약 스킬트리에서 배워야하는 값과 다른 순번으로 skilltree가 구성되어 있다면
                    isAble = false; // false 설정
                    break;
                }
            }
            if (isAble)
                answer++;
        }
        return answer;
    }
 */
