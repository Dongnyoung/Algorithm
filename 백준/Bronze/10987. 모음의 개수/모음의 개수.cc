#include <iostream>
using namespace std;
int main(){
    string s;
    getline(cin,s);
    int cnt=0;
    
    for(int i = 0 ; i<s.size();i++){
        if(s[i]=='a'|| s[i]=='i'|| s[i]=='o' || s[i]=='e'|| s[i]=='u')
            cnt++;
    }
    cout <<cnt<<endl;
}
