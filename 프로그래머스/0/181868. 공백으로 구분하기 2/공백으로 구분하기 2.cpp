#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    string s = "";
    for(char ch : my_string){
        if(ch != ' '){
            s += ch;
        } else {
            if (!s.empty()) {
                answer.push_back(s);
                s = ""; //초기화
            }
        }
    }
    if (!s.empty()) {
        answer.push_back(s);
    }
    return answer;
}
