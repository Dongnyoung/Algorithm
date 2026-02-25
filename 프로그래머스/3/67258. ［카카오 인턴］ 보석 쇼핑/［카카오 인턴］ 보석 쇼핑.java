import java.util.*;
class Solution {
    static Map<String,Integer> type;
    public int[] solution(String[] gems) {
        int[] answer = {};
        type = new HashMap<>();
        
        //종류뽑기
        for(String g : gems){
            if(type.containsKey(g)){
                continue;
            }
            //System.out.print(g+" ");
            type.put(g,0);
        }
        int size = type.size();
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            int len1 = o1[1]-o1[0];
            int len2 = o2[1]-o2[0];
            if(len1 !=len2){
                return Integer.compare(len1,len2);
            }
            return Integer.compare(o1[0],o2[0]);
        });
        int start=0;
        for(int end=0;end<gems.length;end++){
            map.put(gems[end],map.getOrDefault(gems[end],0)+1);
            while(map.size()==size){
                int i=start+1;
                int j=end+1;
                pq.add(new int[]{i,j});
                //System.out.print(i+" "+j);
                map.put(gems[start],map.get(gems[start])-1);
                if(map.get(gems[start])==0){
                    map.remove(gems[start]);
                }
                
                start++;
                
            }
        }       
        answer = pq.poll();
        return answer;
    }
}