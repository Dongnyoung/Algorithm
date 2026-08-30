import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        
        //set에 넣기
        Set<String> set = new HashSet<>();
        for(String p : phone_book){
            set.add(p);
        }
        
        for(String p: phone_book){
            int len = p.length();
            for(int i=1;i<len;i++){
                String prefix = p.substring(0,i);
                //System.out.println(prefix);
                if(set.contains(prefix)){
                    return false;
                }
            }
            
        }
        return answer;
    }
}