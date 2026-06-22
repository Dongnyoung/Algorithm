import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        //int[] answer = {};
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int minute = fees[2];
        int cost = fees[3];
        
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> m = new HashMap<>();
        for(String record : records){
            String[] r = record.split(" ");
            String time =r[0];
            String number =r[1];
            String bool = r[2];
            
            if(bool.equals("IN")){
                map.put(number,time);
            }
            else{
                //out이니까 주차시간
                int parkTime = calc(map.get(number),time);
                m.put(number,m.getOrDefault(number,0)+parkTime);
                map.remove(number);
            }
        }
        
        //23:59출차처리
        for(Map.Entry<String,String> entry : map.entrySet()){
            String number = entry.getKey();
            int parkTime = calc(map.get(number),"23:59");
            m.put(number,m.getOrDefault(number,0)+parkTime);
        }
        
        List<String> car = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : m.entrySet()){
            String number = entry.getKey();
            car.add(number);
        }
        Collections.sort(car,(o1,o2)->Integer.compare(Integer.parseInt(o1),Integer.parseInt(o2)));
        int[] answer = new int[car.size()];
        for(int i=0;i<car.size();i++){
            String number =car.get(i);
            int time = m.get(number);
            if(time<=defaultTime){
                answer[i] = defaultCost;
            }
            else{
                answer[i] = defaultCost+(int)Math.ceil((double)(time-defaultTime)/minute)*cost;
            }
        }
        return answer;
    }
    private static int calc(String start, String end){
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        //시
        int hour = Integer.parseInt(endTime[0])-Integer.parseInt(startTime[0]);
        int hourMinute =hour*60;
        //분
        int minute = Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1]);
        int result = hourMinute+minute;
        return result;
    }
}