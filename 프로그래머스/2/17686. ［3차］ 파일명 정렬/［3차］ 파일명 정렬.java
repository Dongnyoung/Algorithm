import java.util.*;
class Solution {
    static class File{
        String head;
        String number;
        String tail;
        File(String head, String number, String tail){
            this.head=head;
            this.number=number;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {
        
        
        //조건
        //head부분 사전순정렬
        //number는 숫자순(0포함하는지 앞쪽부터)
        
        //head분리
        List<File> fs = new ArrayList<>();
        
        for(int i=0;i<files.length;i++){
            String f = files[i];
            char[] fc = f.toCharArray();
            int idx = 0;
            int nIdx = fc.length;
            //숫자체크
            for(int j=0;j<fc.length;j++){
                if(Character.isDigit(fc[j])){
                    idx = j;
                    break;
                }
            }
            //number어디까지?
            for(int j=idx;j<fc.length;j++){
                if(!Character.isDigit(fc[j])){
                    nIdx = j;
                    break;
                }
            }
            
            //head추출, head리스트에넣고 hashmap에도 넣어야함
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for(int j=0;j<idx;j++){
                sb1.append(fc[j]);
            }
            //number추출
            for(int j=idx;j<nIdx;j++){
                sb2.append(fc[j]);
            }
            //tail추출
            for(int j=nIdx;j<fc.length;j++){
                sb3.append(fc[j]);
            }
            String h = sb1.toString();
            String nums = sb2.toString();
            String tails = sb3.toString();
            //System.out.println(h+" "+nums);
            fs.add(new File(h,nums,tails));
            
            
        }
        //System.out.println(fs.size());
        
        Collections.sort(fs,(o1,o2)->{
            String str1 = o1.head.toLowerCase();
            String str2 = o2.head.toLowerCase();
           if(!str1.equals(str2)){
               return str1.compareTo(str2);
           }
            int num1 = Integer.parseInt(o1.number);
            int num2 = Integer.parseInt(o2.number);
            if(num1!=num2){
                return Integer.compare(num1,num2);
            }
            return 0;
        });
        String[] answer = new String[fs.size()];
        
        for(int i=0;i<fs.size();i++){
            File f = fs.get(i);
            answer[i] = f.head+f.number+f.tail;
        }
        
        return answer;
    }
    
}