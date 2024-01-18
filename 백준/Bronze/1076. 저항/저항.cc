#include <iostream>
#include <string>
using namespace std;
//앞 두개는 차례대로 , 뒤에 하나는 곱

int main() {
  //색깔
  string color[10]= {"black","brown","red","orange","yellow"	,"green","blue","violet","grey","white"};
  string c;
  //읽을값
  int name[3];
  long long result=0;

  //입력
  for(int i=0; i<3; i++){
    cin>>c;
    for(int j=0; j<10; j++){
      if(color[j]==c) name[i]=j;
    }
  }
  //출력
  result = name[0]*10 +name[1];
  for(int i=0; i<name[2]; ++i) result*=10;
  cout << result << endl;
  return 0;
}