import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int[][] nums = new int[N][M];
        for(int i = 0;i < N;i++) {

            for(int j = 0;j < M;j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<Math.min(N,M)/2;j++){
                int top = j;
                int left = j;
                int bottom = N-1-j;
                int right = M-1-j;
                //1. 오->왼
                int temp = nums[top][left]; //하나 밑의끝값
                for(int k=left;k<right;k++){
                    nums[top][k] = nums[top][k+1];
                }
                //2. 아래->위
                //int temp2 = nums[left][bottom];
                for(int k=top;k<bottom;k++){
                    nums[k][right] = nums[k+1][right];
                }

                //3. 왼->오
                for(int k=right;k>left;k--){
                    nums[bottom][k] = nums[bottom][k-1];
                }

                //4. 위->아래
                for(int k=bottom;k>top;k--){
                    nums[k][left] = nums[k-1][left];
                }
                nums[top+1][left] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(nums[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }



}
