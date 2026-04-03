import java.util.*;

public class Main {

    static class Student{
        int time,number;

        public Student(int time, int number){
            this.time = time;
            this.number = number;
        }
    }

    static int dx[] = {-1,1,0,0,0,0};
    static int dy[] ={0,0,-1,1,0,0};
    static int df[] = {0,0,0,0,1,-1};
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N  = sc.nextInt();
        int M = sc.nextInt();
        int[] recs = new int[M];
        Map<Integer, Student> students = new HashMap<>();

        for(int i=0;i<M;i++){
            recs[i] = sc.nextInt();
        }

        for(int i=0;i<M;i++){
            int recNum = recs[i];
            //이미존재하는학생이라면
            if(students.containsKey(recNum)){
                students.get(recNum).number++;
            }
            else{
                if(check(students)){
                    //꽉찼다면
                    delete(students);

                }
                students.put(recNum,new Student(i,1));
            }



        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Student> entry : students.entrySet()){
            ans.add(entry.getKey());
        }
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    static boolean check(Map<Integer, Student> students){
        if(N == students.size()){
            return true;
        }
        return false;
    }
    static void delete(Map<Integer,Student> students){
        int count = 1001;
        int minKey = 0;
        for(Map.Entry<Integer,Student> entry : students.entrySet()){
            int key = entry.getKey();
            Student student = entry.getValue();
            if(count>student.number){
                count = student.number;
                minKey = key;
            }
        }
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Student> entry : students.entrySet()){
            int key = entry.getKey();
            Student student = entry.getValue();
            if(student.number == count){
                list.add(new int[]{key,student.time});
            }
        }
        if(list.size()>=2){
            Collections.sort(list,(o1,o2)-> Integer.compare(o1[1],o2[1]));
            students.remove(list.get(0)[0]);
            return;
        }

        students.remove(minKey);
    }
}