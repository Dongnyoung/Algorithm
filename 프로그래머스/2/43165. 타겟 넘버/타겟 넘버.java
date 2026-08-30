import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int answer = 0;
        q.add(0);
        for(int num:numbers){
            int plus = num;
            int minus = -num;
            int size= q.size();
            for(int i=0;i<size;i++){
                int sum=q.poll();
                q.add(sum+plus);
                q.add(sum-plus);
            }
        }
        while(!q.isEmpty()){
            if(target==q.poll()){
                answer++;
            }
        }
        return answer;
    }
}