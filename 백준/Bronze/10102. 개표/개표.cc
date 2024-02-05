#include <iostream>
#include <cstring>
using namespace std;

int N;
string arr;
int a, b;

int main(){
    cin.tie(0);
    cout.tie(0);
    cin >> N;
    cin >> arr;
    for(int i = 0; i < arr.size(); i++){
        if(arr[i] == 'A') a++;
        else b++;
    }
    if(a > b) cout << "A";
    else if(b > a) cout << "B";
    else cout << "Tie";
    return 0;
}
