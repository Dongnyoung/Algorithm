import java.util.*;
class Solution {
    static class Point{
        int x,y,number;
        Point(int x, int y, int number){
            this.x=x;
            this.y=y;
            this.number=number;
        }
    }
    static Point[] pointList;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph = new int[101][101];
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int len = points.length;
        pointList = new Point[len];
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                graph[i][j] = -1;
            }
        }
        for(int[] p: points){
            p[0]-=1;
            p[1]-=1;
        }
        
        
        //System.out.println(points[0][0]+","+points[0][1]);
        boolean visited[][] = new boolean[101][101];
        
        //포인트지점
        for(int i=0;i<points.length;i++){
            int[] p = points[i];
            int x = p[0];
            int y =p[1];
            pointList[i] = new Point(x,y,i);
            visited[x][y] = true;
        }
        List<List<int[]>> totalPath = new ArrayList<>();
        //최단거리 찾기
        for(int[] r: routes){
            List<int[]> robotPath = new ArrayList<>();

            for (int i = 0; i < r.length - 1; i++) {
                Point start = pointList[r[i]-1];
                Point end = pointList[r[i+1]-1];

                List<int[]> path = makePath(start, end);

                if (i > 0) {
                    path.remove(0); // 구간 연결 시 중복 제거
                }
                robotPath.addAll(path);
            }
            totalPath.add(robotPath);
        }
        int maxTime = 0;
        for(List<int[]> p: totalPath){
            if(maxTime<p.size()){
                maxTime = p.size();
            }
        }
        
        for(int i=0;i<maxTime;i++){
            Map<String,Integer> map = new HashMap<>();
            for(List<int[]> p : totalPath){
                if(i>=p.size()){
                    continue;
                }
                int[] pos = p.get(i);
                String key = pos[0]+","+pos[1];
                map.put(key,map.getOrDefault(key,0)+1);
            }
            for (int count : map.values()) {
                if (count >= 2) answer++;
            }
        }
        return answer;
    }
    static List<int[]> makePath(Point start, Point end) {
        List<int[]> path = new ArrayList<>();

        int r = start.x;
        int c = start.y;

        path.add(new int[]{r, c});

        while (r != end.x) {
            if (r < end.x) r++;
            else r--;
            path.add(new int[]{r, c});
        }

        while (c != end.y) {
            if (c < end.y) c++;
            else c--;
            path.add(new int[]{r, c});
        }

        return path;
    }
    static void print(List<int[]> path){
        for(int[] p :path){
            System.out.print(p[0]+","+p[1]+" ");
        }
        System.out.println();
    }
}