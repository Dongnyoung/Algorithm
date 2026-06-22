import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        //mecro
        Map<String,String> map = new HashMap<>();
        map.put("Enter","님이 들어왔습니다.");
        map.put("Leave","님이 나갔습니다.");
        
        Map<String,String> idMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String re : record){
            String[] cmd = re.split(" ");
            String command = cmd[0];
            String id = cmd[1];
            
            if(command.equals("Enter")){
                String name = cmd[2];
                idMap.put(id,name);
                result.add("Enter"+","+id);
            }
            else if(command.equals("Leave")){
                result.add("Leave"+","+id);
            }
            else{
                String name =cmd[2];
                idMap.put(id,name);
            }
        }
        String[] answer = new String[result.size()];
        
        for(int i=0;i<result.size();i++){
            String cmdAndId = result.get(i);
            String[] line = cmdAndId.split(",");
            String cmd = line[0];
            String id = line[1];
            
            answer[i] = idMap.get(id)+map.get(cmd);
        }
        return answer;
    }
}