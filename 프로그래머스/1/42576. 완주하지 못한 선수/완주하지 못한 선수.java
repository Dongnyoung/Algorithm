import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //해시맵으로 참가자를 체킹하고
        HashMap<String,Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        //소거
        for(String c : completion){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }
        }
        
        //>0이면 완주x
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String partici = entry.getKey();
            int count = entry.getValue();
            if(count>0){
                sb.append(partici);
            }
        }
        answer =sb.toString();
        return answer;
    }
}