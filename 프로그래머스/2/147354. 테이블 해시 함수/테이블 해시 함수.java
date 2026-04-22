import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //정렬: col기준 오름차순, 같으면 첫번째칼럼 값 기준 내림차순 정렬
        Arrays.sort(data,(o1,o2)->{
            int primaryKey1 = o1[0];
            int primaryKey2 = o2[0];
           if(o1[col-1]!=o2[col-1]){
               return Integer.compare(o1[col-1],o2[col-1]);
           } 
            return Integer.compare(o2[0],o1[0]);
        });
        int result=0;
        for(int i=row_begin-1;i<row_end;i++){
            int[] columns = data[i];
            int idx = i+1;
            int sum=0;
            for(int c : columns){
                sum += c%idx;
                
            }
            //System.out.println(sum);
            result^=sum;
            
        }
        answer = result;
        
        return answer;
    }
}