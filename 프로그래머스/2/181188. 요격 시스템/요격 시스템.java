import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(o1,o2)->{
           return Integer.compare(o1[1],o2[1]); 
        });
        
        int m =-1;
        
        for(int[] target:targets){
            if(m<=target[0]){
                m=target[1];
                answer++;
            }
        }
        return answer;
    }
}