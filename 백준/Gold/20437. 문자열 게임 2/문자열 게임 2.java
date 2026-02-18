import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> list;
    static String words;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            words = sc.next();
            int K= sc.nextInt();
            list = new ArrayList<>();
            for(int j = 0; j < words.length(); j++) {
                check(j,K);
            }
            Collections.sort(list);
            if(list.isEmpty()){
                System.out.println("-1");
                continue;
            }
            System.out.println(list.get(0)+" "+list.get(list.size()-1));
        }


    }
    private static void check(int index, int k) {
        if(k==1){
            list.add(1);
            return;
        }
        int count=1;
        if(index+1 <= words.length()) {
            for(int i = index+1; i < words.length(); i++) {
                if(words.charAt(i) == words.charAt(index)) {
                    count++;
                }
                if(count == k) {
                    list.add(i-index+1);
                    break;
                }
            }
        }
        else{
            return;
        }
    }



}