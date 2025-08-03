import java.util.*;
class Solution {
    //정답 
    public static Map<String,Integer> result = new HashMap<>();
        
        //트리 자식-부모
     public static Map<String,String> tree = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    
        
        
        for(int i=0;i<enroll.length;i++){
            tree.put(enroll[i],referral[i]);
            result.put(enroll[i],0);
            //System.out.println(tree.get(enroll[i]));
        }
        
        //Map<String,Integer> selling = new HashMap<>();
        //for(int i=0;i<seller.length;i++){
            //selling.put(seller[i],selling.getOrDefault(seller[i],0)+amount[i]*100);
            //System.out.println(selling.get(seller[i]));
        //}
        //수익금
        for(int i=0;i<seller.length;i++){
            //금액-금액의10퍼 받기
            int price = amount[i]*100;
            
            findParent(seller[i],price);
        }
        int answer[] =new int[result.size()];
        for(int i=0;i<enroll.length;i++){
            answer[i]=result.get(enroll[i]);
        }
        return answer;
    }
    public static void findParent(String child,int price){
        
        
        if(child.equals("-") || price<1){
            return;
        }
        
        int discountPrice = price/10;
        int discount = price-discountPrice;
        //System.out.print("parent: "+parent+ "+"+discount);
        result.put(child,result.get(child)+discount);
        String parent = tree.get(child);
        findParent(parent,discountPrice);
    }
}