import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        String[] alpha = {
          "a","b","c","d","e","f","g","h","i","j","k","l","m",
        "n","o","p","q","r","s","t","u","v","w","x","y","z"
        };
        int answer = 0;
        //대소문자 구분 x
        String s1= str1.toLowerCase();
        String s2 = str2.toLowerCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(int i=0;i<s1.length();i++){
            if(i==s1.length()-1){
                break;
            }
            String temp = s1.substring(i,i+2);
            if(isAlpha(temp,alpha)){
                list1.add(temp);
            }
            
        }
        for(int i=0;i<s2.length();i++){
            if(i==s2.length()-1){
                break;
            }
            String temp = s2.substring(i,i+2);
            if(isAlpha(temp,alpha)){
                list2.add(temp);
            }
        }
        
        //합집합은 없는거 넣기 
        List<String> hab = new ArrayList<>(list1);
        List<String> tp = new ArrayList<>(list1);
        
        for(String s : list2){
            if(!tp.remove(s)){
                hab.add(s);
            }
        }
        
        List<String> gyo = new ArrayList<>();
        List<String> tp2 = new ArrayList<>(list2);
        
        for(String s: list1){
            if(tp2.remove(s)){
                gyo.add(s);
            }
        }
        if(hab.size()==0){
            return 65536;
        }
        double jacard = (double) gyo.size()/hab.size();
        jacard*=65536;
        
        //System.out.println(s1+" "+s2);
        return (int)jacard;
    }
    static boolean isAlpha(String temp, String[] alpha){
        for(int i=0;i<temp.length();i++){
            String t = temp.substring(i,i+1);
            boolean flag = false;
            for(int j=0;j<alpha.length;j++){
                if(t.equals(alpha[j])){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}