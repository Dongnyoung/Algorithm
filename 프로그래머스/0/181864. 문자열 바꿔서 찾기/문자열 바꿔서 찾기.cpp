#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    string s;
    for(char ch :myString){
        if(ch =='A')
            s+='B';
        else
            s+='A';
    }
    if(s.find(pat)!=string::npos)
        answer =1;
    else 
        answer =0;
    
    return answer;
}