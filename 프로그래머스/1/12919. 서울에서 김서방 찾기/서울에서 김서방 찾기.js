function solution(seoul) {
    let n;
    
    for(let i=0;i<seoul.length;i++){
        if(seoul[i]=="Kim"){
            n=i;
            break;
        }
        else{
            continue;
        }
    }
    var answer = '김서방은 '+n+'에 있다';
    return answer;
}