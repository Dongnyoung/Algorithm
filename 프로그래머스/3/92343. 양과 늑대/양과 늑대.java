import java.util.*;

class Solution {
    int maxSheep = 0;

    static class Node {
        int animal; // 0: 양, 1: 늑대
        List<Integer> children = new ArrayList<>();

        public Node(int animal) {
            this.animal = animal;
        }
    }

    public int solution(int[] info, int[][] edges) {
        Node[] nodes = new Node[info.length];

        // 노드 생성
        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(info[i]);
        }

        // 부모-자식 연결
        for (int[] edge : edges) {
            nodes[edge[0]].children.add(edge[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(nodes[0].children);

        dfs(nodes, 0, 1, 0, nextNodes);

        return maxSheep;
    }

    void dfs(Node[] nodes, int current, int sheep, int wolf, List<Integer> nextNodes) {
        maxSheep = Math.max(maxSheep, sheep);

        for (int i = 0; i < nextNodes.size(); i++) {
            int next = nextNodes.get(i);
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (nodes[next].animal == 0) nextSheep++;
            else nextWolf++;

            if (nextWolf >= nextSheep) continue;

            // 다음 방문 가능 노드 업데이트
            List<Integer> newList = new ArrayList<>(nextNodes);
            newList.remove(i);
            newList.addAll(nodes[next].children);

            dfs(nodes, next, nextSheep, nextWolf, newList);
        }
    }
}
