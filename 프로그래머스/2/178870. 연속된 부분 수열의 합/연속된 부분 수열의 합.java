import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            int len = o1[1]-o1[0];
            int len2 = o2[1]-o2[0];
            if(len==len2){
                return Integer.compare(o1[0],o2[0]);
            }
            return Integer.compare(len,len2);
            
        });
        int start = 0;
        int sum=0;
        for(int end = 0; end<sequence.length;end++){
            sum += sequence[end];
            while(sum> k && start<=end){
                sum-=sequence[start++];
            }
            if(sum==k){
                pq.add(new int[]{start,end});
            }
        }
        //정답은 시작의 인덱스, 마지막 인덱스
        answer = pq.poll();
        return answer;
    }
}