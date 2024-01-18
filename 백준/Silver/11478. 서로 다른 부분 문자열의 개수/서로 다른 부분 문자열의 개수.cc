#include <iostream>
#include <set>
using namespace std;
int main() {
  //입력
  string s;
  cin >> s;
  //중복제거 정의
  set<string> set_s;
  //출력
  string str = "";
  for (int i=0; i<s.size(); i++){
    for (int j=i; j<s.size(); j++){
      str+=s[j];
      set_s.insert(str);
    }
    str="";
  }
  //중복제거
  cout << set_s.size();
}