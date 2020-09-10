package highscorekit.hash.bestalbum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestAlbum {
    @Test
    public void test() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = {4, 1, 3, 0};
        
        int[] solution = solution(genres, plays);
        assertEquals(solution[0], 4);
        assertEquals(solution[1], 1);
        assertEquals(solution[2], 3);
        assertEquals(solution[3], 0);
        
        String[] genres2 = {"a", "a", "a", "b", "b", "c"};
        int[] plays2 = {500, 600, 500, 1700, 500, 200};
        int[] solution2 = solution(genres2, plays2);
        assertEquals(solution2[0], 3);
        assertEquals(solution2[1], 4);
        assertEquals(solution2[2], 1);
        assertEquals(solution2[3], 0);
        assertEquals(solution2[4], 5);
        assertEquals(solution2.length, 5);
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genreSums = new HashMap<>();
        HashMap<String, List<Info>> songInGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreSums.put(genres[i], genreSums.getOrDefault(genres[i], 0) + plays[i]);
            if (!songInGenre.containsKey(genres[i])) {
                songInGenre.put(genres[i], new ArrayList<>());
            }
            songInGenre.get(genres[i]).add(new Info(i, plays[i]));
        }
        for (String key : songInGenre.keySet()) {
            songInGenre.get(key).sort((o1, o2) -> {
                return Integer.compare(o2.getPlay(), o1.getPlay());
            });
        }
        List<String> sortedGenre = genreSums.keySet().stream().sorted((o1, o2) -> {
            return Integer.compare(genreSums.get(o2), genreSums.get(o1));
        }).collect(Collectors.toList());
        for (String genre : sortedGenre) {
            answer.addAll(songInGenre.get(genre).stream().limit(2).map(Info::getIndex).collect(Collectors.toList()));
        }
        return answer.stream().mapToInt(a -> a).toArray();
    }
    
}

class Info {
    private int index;
    private int play;
    
    public Info(int index, int play) {
        this.index = index;
        this.play = play;
    }
    
    public int getIndex() {
        return index;
    }
    
    public int getPlay() {
        return play;
    }
}

// 가장 인기있는 풀이!! (근대 솔직히 내가 더 잘 푼 것 같다.)
/*
public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Object> genresMap = new HashMap<String, Object>();      //<장르, 곡 정보>
        HashMap<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>
        ArrayList<Integer> resultAL = new ArrayList<Integer>();
        
        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            HashMap<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>
            
            if(genresMap.containsKey(key)){
                infoMap = (HashMap<Integer, Integer>)genresMap.get(key);
            }
            else {
                infoMap = new HashMap<Integer, Integer>();
            }
            
            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);
            
            //재생수
            if(playMap.containsKey(key)){
                playMap.put(key, playMap.get(key) + plays[i]);
            }
            else {
                playMap.put(key, plays[i]);
            }
        }
        
        int mCnt = 0;
        Iterator it = sortByValue(playMap).iterator();
        
        while(it.hasNext()){
            String key = (String)it.next();
            Iterator indexIt = sortByValue((HashMap<Integer, Integer>)genresMap.get(key)).iterator();
            int playsCnt = 0;
            
            while(indexIt.hasNext()){
                resultAL.add((int)indexIt.next());
                mCnt++;
                playsCnt++;
                if(playsCnt > 1) break;
            }
        }
        
        int[] answer = new int[resultAL.size()];
        
        for(int i = 0; i < resultAL.size(); i++){
            answer[i] = resultAL.get(i).intValue();
        }
        
        return answer;
    }
    
    private ArrayList sortByValue(final Map map){
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());
        
        Collections.sort(keyList, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                
                return ((Comparable) v2).compareTo(v1);
            }
        });
        
        return keyList;
    }
}
 */