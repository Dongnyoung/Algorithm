
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;
int n,lenK, result;
vector <int> k;
void make(int num){
    if(num>n){
        return;
    }
    result =max(result,num);
    num *=10;
    for(int i=0; i<lenK;i++){
        make(num+k[i]);
    }
}
    
int main() {
    fastio;
    
    cin >> n >> lenK;
    for(int i=0; i<lenK;i++){
        int k_num;
        cin >> k_num;
        k.push_back(k_num);
    }
    make(0);
    cout << result << '\n';
    
}
    
