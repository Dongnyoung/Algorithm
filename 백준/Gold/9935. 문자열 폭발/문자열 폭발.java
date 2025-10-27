import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String bomb = scan.nextLine();

        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()) {
            sb.append(c);
            if(sb.length()>=bomb.length()) {
                boolean flag=true;
                for(int i=0;i<bomb.length();i++) {
                    if(sb.charAt(sb.length()-bomb.length()+i)!=bomb.charAt(i)) {
                        flag=false;
                        break;
                    }

                }
                if(flag) {
                    sb.replace(sb.length()-bomb.length(),sb.length(),"");
                }
            }

        }
        System.out.println(sb.isEmpty() ? "FRULA":sb.toString());
    }
}