import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        //우선순위 큐에 담고 target보다 작을때 사용하자
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
        
        
        if(enemy.length==k){
            return enemy.length;
        }
        
        
        for(int i=0;i<enemy.length;i++){
            int target = enemy[i];
            n-=target;
            pq.add(target);
            if(n<0){
                if(k==0){
                    return i; 
                }
                n += pq.poll();
                
                k--;
            }
        }
        
        
        return enemy.length;
    }
}