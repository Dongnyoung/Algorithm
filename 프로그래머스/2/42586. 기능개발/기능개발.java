import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //배포될 작업 수
        Queue <Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length;
        //작업일 수 배열
        int leftDays[] = new int[n];
        for(int i=0; i<n;i++){
            leftDays[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        //기준일
        int maxDay = leftDays[0];
        int count=0;
        for(int i=0;i<n;i++){
            if(maxDay>=leftDays[i]){
                count++;
            }
            else{
                answer.add(count);
                count=1;//초기화
                maxDay=leftDays[i];
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}