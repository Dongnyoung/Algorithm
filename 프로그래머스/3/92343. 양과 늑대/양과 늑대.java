import java.util.*;
class Solution {
    int answer = 0;
    static class Node{
        int animal;
        List<Integer> children = new ArrayList<>();
        public Node(int animal){
            this.animal=animal;
        }
    }
    public int solution(int[] info, int[][] edges) {
        
        Node[] nodes = new Node[info.length];
        //노드 생성
        for(int i=0;i<info.length;i++){
            nodes[i] = new Node(info[i]);
        }
        //부모-자식 연결
        for(int edge[]:edges){
            int parent = edge[0];
            int child = edge[1];
            nodes[parent].children.add(child);
        }
        
        //자식 그릇
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(nodes[0].children);
        
        dfs(nodes,0,1,0,nextNodes);
        
        return answer;
    }
    void dfs(Node[] nodes, int current, int sheepCount,int wolfCount,List<Integer> nextNodes){
        answer = Math.max(answer,sheepCount);
        for(int i=0;i<nextNodes.size();i++){
            int next = nextNodes.get(i);
            int nextSheep = sheepCount;
            int nextWolf = wolfCount;
            if(nodes[next].animal==0) nextSheep++;
            else nextWolf++;
            
            if(nextSheep<=nextWolf) continue;
            
            List<Integer> nextNodeChild = new ArrayList<>(nextNodes);
            nextNodeChild.remove(i);
            nextNodeChild.addAll(nodes[next].children);
            
            dfs(nodes, next, nextSheep,nextWolf,nextNodeChild);
        }
    }
}