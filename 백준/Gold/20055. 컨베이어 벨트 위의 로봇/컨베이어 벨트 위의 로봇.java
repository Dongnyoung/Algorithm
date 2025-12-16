import java.util.*;

public class Main {
    private static ArrayList<Integer> belt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        belt = new ArrayList<>();
        boolean[] robot = new boolean[N*2];
        for(int i=0;i<N*2;i++){
            belt.add(sc.nextInt());
        }
        for(int i=0;i<N*2;i++){
            robot[i] =false;
        }
        int count =0;
        while(true){

            if(check(belt,K)){
                break;
            }
            count++;

            //1단계 벨트회전(로봇과 같이)
            rotate(belt,robot,N);

            //2단계 먼저 올라간 로봇부터 이동 체크
            moveCheck(robot, belt,N);
            //3단계 로봇 올리기
            onRobot(robot,belt);
        }
        System.out.println(count);

    }
    private static boolean check(ArrayList<Integer> belt,int K){
        int zeroCount = 0;
        for(int i=0;i<belt.size();i++){
            if(belt.get(i) == 0){
                zeroCount++;
            }
        }
        if(zeroCount >= K){
            return true;
        }
        return false;
    }
    private static void rotate(ArrayList<Integer> belt, boolean[] robot,int N){
        int temp = belt.get(belt.size()-1);
        for(int i=belt.size()-1;i>=1;i--){

            belt.set(i,belt.get(i-1));

        }
        belt.set(0,temp);

        //robot
        boolean r = robot[belt.size()-1];
        for(int i=robot.length-1;i>=1;i--){

            robot[i] = robot[i-1];

        }
        robot[0] =r;
        robot[N-1] =false;

    }
    private static void moveCheck(boolean[] robot, ArrayList<Integer> belt, int N) {
        // 뒤에서부터 이동
        for (int i = N - 2; i >= 0; i--) {
            // robot이 존재하고 다음 칸에 로봇이 존재하지 않고 다음칸 내구성이 0보다는 커야함
            if (robot[i] && !robot[i + 1] && belt.get(i + 1) > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt.set(i + 1, belt.get(i + 1) - 1);
            }
        }
        // 이동 후 내리기
        robot[N - 1] = false;
    }
    private static void onRobot(boolean[] robot, ArrayList<Integer> belt){
        //로봇 올리기
        if(belt.get(0)>=1 && robot[0] == false){
            robot[0] = true;
            belt.set(0, belt.get(0)-1);
        }
    }

}
