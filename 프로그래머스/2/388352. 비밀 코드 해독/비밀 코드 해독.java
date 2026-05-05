import java.util.*;
class Solution {
    static int answer;
    static int[][] qList;
    static int[] ansList;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        qList = q;
        ansList = ans;
        dfs(1,0,n,new int[5]);
        return answer;
    }
    static void dfs(int start,int depth,int n,int[] secret){
        if(depth==5){
            if(valid(secret)){
                answer++;
            }
            return;
        }
        
        for(int i=start;i<=n;i++){
            secret[depth] = i;
            dfs(i+1,depth+1,n,secret);
        }
    }
    static boolean valid(int[] secret){
        HashSet<Integer> set = new HashSet<>();
        for(int s: secret){
            set.add(s);
        }
        for(int i=0;i<qList.length;i++){
            int[] l = qList[i];
            
            int count=0;
            for(int a: l){
                if(set.contains(a)){
                    count++;
                }
            }  
            if(ansList[i] != count){
                return false;
            }
        }
        return true;
    }
}