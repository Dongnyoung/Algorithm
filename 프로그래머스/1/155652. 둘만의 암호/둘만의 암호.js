function solution(s, skip, index) {
    //index만큼 +를 하면되는데 +할때마다  skip에 있는 알파벳이있다면 넘어감 
    var alpha = 'abcdefghijklmnopqrstuvwxyz';
    var filtered = alpha.split('').filter(char=>!skip.includes(char));
    
    let answer='';
    for(let char of s){
        //필터된 인덱스
        let currentIndex = filtered.indexOf(char);
        let newIndex = (currentIndex+index)%filtered.length;
        answer+=filtered[newIndex];
    }
    return answer;
}