#include <iostream>
#include <stack>
using namespace std;

void stackprint(stack<char>&s){
    while(!s.empty()){
        cout << s.top();
        s.pop();
    }
}
int main(){
    stack<char>s;
    string str;
    getline(cin,str);
    for(int i=0; i<str.size();i++){
        if(str[i]=='<'){
            stackprint(s);
            while(true){
                cout<<str[i];
                if(str[i]=='>')
                    break;
                i++;
            }
        }
        else if(str[i]== ' '){
            stackprint(s);
            cout << ' ';
        }
        else{
            s.push(str[i]);
        }
            
    }
    stackprint(s);
    
}
