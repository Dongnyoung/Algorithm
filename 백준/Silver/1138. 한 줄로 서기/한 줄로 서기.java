import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            visited[i] = false;
        }
        sc.nextLine();
        for(int i=1;i<=N;i++){
            int num = sc.nextInt();
            map.put(i,num);
        }
        //빈칸(false)인게 해당 값과 같다면 거기에 넣자
        int[] nums = new int[N];
        nums[map.get(1)] = 1;
        visited[map.get(1)] = true;
        for(int i=1;i<N;i++){
            int loc =check(i+1,map.get(i+1));
            nums[loc] =i+1;
            visited[loc] = true;

        }
        for(int i=0;i<N;i++){
            System.out.print(nums[i]+ " ");
        }
    }
    private static int check(int num, int value) {
        int count=0;
        //빈칸(false)차직 왼쪽에서
        for(int i=0;i<N;i++){

            if(!visited[i]){
                count++;
            }
            if(count==value && !visited[i + 1]){
                return i+1;

            }
        }
        return 0;

    }
}