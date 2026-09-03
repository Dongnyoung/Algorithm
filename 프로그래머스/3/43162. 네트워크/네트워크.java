import java.util.*;
class Solution {
    static List<Integer>[] list;
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            list[i]= new ArrayList<>();
        }
        for(int i=0;i<computers.length;i++){
            //1을 찾아야하는데 [i][i]는 패쓰
            for(int j=0;j<computers[i].length;j++){
                if(i==j){
                    continue;
                }
                if(computers[i][j]==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    //dfs는 즉, 연결된 트리에서 노드의 개수를 리턴하고 전체에서 그 개수를 빼면 남은게 나오고 남은거에 +1하면됨
    static private int dfs(int computer){
        int cnt=1;
        visited[computer] =true;
        for(int next: list[computer]){
            if(!visited[next]){
                
                int childCnt = dfs(next);
                cnt+=childCnt;
            }
            
        }
        return cnt;
    }
}