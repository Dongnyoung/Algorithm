#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    for(char&ch : myString)
        ch=toupper(ch);
    for(char&ch : pat)
        ch = toupper(ch);
    if(myString.find(pat)!=string::npos)
        answer =1;
    else
        answer =0;
    return answer;
}