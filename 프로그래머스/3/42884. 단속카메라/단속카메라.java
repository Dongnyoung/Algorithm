import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //정렬
        Arrays.sort(routes,(o1,o2)->{
           return Integer.compare(o1[1],o2[1]); 
        });
        
        int camera=-30000;
        for(int[] r: routes){
            int start = r[0];
            int end =r[1];
            if(camera<start){
                camera = end;
                answer++;
            }
        }
        return answer;
    }
}