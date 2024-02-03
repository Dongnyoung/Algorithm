#include <iostream>
#include <stack>
using namespace std;

void printstack(stack<char> &s) {
    while (!s.empty()) {
        cout <<s.top();
        s.pop();
    }
}

int main() {
    int T;        //테스트 케이스
        string sentence;    //문장 (길이 최대 1000) 단어길이: 20
        stack <char> s;    //단어를 뒤집기 위한 스택
     
        cin >> T;
        cin.ignore();    //버퍼 비우기
        while (T--)
        {
            getline(cin, sentence);
            sentence += ' ';
            
            for (int i = 0; i < sentence.size(); i++)
            {
                if (sentence[i] == ' ')
                {
                    printstack(s);
                    cout << ' ';
                }
                else
                    s.push(sentence[i]);
            }
        }
     
    }

