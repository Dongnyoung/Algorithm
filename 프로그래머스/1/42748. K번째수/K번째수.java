//array의 인덱스를 commands[i][0]부터 commands[i][1]까지 자르고 오름차순을 하고 그중 array[commands[i][2]]를 뽑아서 int[]에 넣어라.
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length;i++){
            int first = commands[i][0];
            int last = commands[i][1];
            int pick = commands[i][2];
            
            int[] sliceArr = Arrays.copyOfRange(array,first-1,last);
            Arrays.sort(sliceArr);
            answer[i] = sliceArr[pick-1];
            
        }
        return answer;
    }
}