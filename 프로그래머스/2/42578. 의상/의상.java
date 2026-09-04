import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for(String[] c:clothes){
            map.put(c[1],map.getOrDefault(c[1],0)+1);
        }
        
        int temp=1;
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            temp*=(entry.getValue()+1);
        }
        answer = temp-1;
        return answer;
    }
}