#include <string>
#include <vector>
#include <cctype>
using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    
    for(int i=0;i<strArr.size();i++){
        string s = strArr[i];
        if(i%2==0){
            for(char &ch : s)
                ch = tolower(ch);
            }
        
        else
        {
            for(char &ch : s)
                ch = toupper(ch);
            }
        answer.push_back(s);
    }
    
    return answer;
}