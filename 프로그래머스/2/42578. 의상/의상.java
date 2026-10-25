import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            String type = clothe[1];
            map.put(type,map.getOrDefault(type,0)+1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            answer*=(1+entry.getValue());
        }
        return answer-1;
    }
}