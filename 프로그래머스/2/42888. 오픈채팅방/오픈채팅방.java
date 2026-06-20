import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String,String> map = new HashMap<>();
        //쪼개기
        for(String r : record){
            //명령어, 아이디, 닉네임
            String[] re = r.split(" ");
            String cmd = re[0];
            String id = re[1];
            
            
            if(cmd.equals("Enter")){
                String nickName = re[2];
                answer.add(id+","+cmd); // id,cmd 저장
                map.put(id,nickName); //id - 닉네임 넣기
            }
            else if(cmd.equals("Leave")){
                answer.add(id+","+cmd);
            }
            else{
                String nickName = re[2];
                map.put(id,nickName);
            }
        }
        
        String[] ans = new String[answer.size()];
        for(int i=0;i<ans.length;i++){
            String line = answer.get(i);
            String[] lines = line.split(",");
            String id = lines[0];
            String command = lines[1];
            if(command.equals("Enter")){
                ans[i] = map.get(id)+"님이 들어왔습니다.";
            }
            else{
                ans[i] = map.get(id)+"님이 나갔습니다.";
            }
        }
        return ans;
    }
}