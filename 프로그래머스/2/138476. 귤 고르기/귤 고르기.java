import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        //많은것부터 채우기
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int type : tangerine){
            map.put(type,map.getOrDefault(type,0)+1);
        }
        
        List<Integer> sorted = new ArrayList<>(map.values());
        sorted.sort(Collections.reverseOrder());
        
        int sum=0;
        int type=0;
        for(int num : sorted){
            sum+=num;
            type++;
            if(sum>=k){
                return type;
            }
        }
        return type;
    }
}