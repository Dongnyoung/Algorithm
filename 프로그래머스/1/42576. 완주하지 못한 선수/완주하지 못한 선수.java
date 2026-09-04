import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        for(String part: participant){
            map.put(part,map.getOrDefault(part,0)+1);
        }
        for(String c: completion){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()!=0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}