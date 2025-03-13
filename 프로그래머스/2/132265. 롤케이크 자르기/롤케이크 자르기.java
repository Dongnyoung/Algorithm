import java.util.*;
class Solution {
    public int solution(int[] topping) {
        //해쉬맵으로 풀자
        HashMap<Integer,Integer> first = new HashMap<>();
        HashMap<Integer,Integer> second = new HashMap<>();
        int answer=0;
        for(int i : topping){
            first.put(i,first.getOrDefault(i,0)+1);
        }
        for(int i : topping){
            second.put(i,first.getOrDefault(i,0)+1);
            if(first.get(i) ==1)
                first.remove(i);
            else
                first.put(i,first.get(i)-1);
            if(first.size()==second.size())
                answer++;
        }
        return answer;
    }
}