#include <iostream>
//1월 1일이 월요일
using namespace std;
int main() {
  int month[12] = {31,28,31,30,31,30,31,31,30,31,30};
  string day[7] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
  int x,y;
  cin >> x>>y;
  //1일로부터 며칠 떨어져있는지?
  for (int i=0; i<x-1; i++){
    y+=month[i];
  }
  cout << day[y%7];

  
}
