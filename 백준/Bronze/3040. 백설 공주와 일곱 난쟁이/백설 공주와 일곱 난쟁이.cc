
#include <iostream>
#include <vector>
#include <algorithm>

#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;


    
int main() {
    fastio;
    int sum=0;
    int a=0,b=0;
    vector <int> dwarf(9);
    for(int i=0;i<9;i++){
        cin >> dwarf[i];
        sum += dwarf[i];
    }
    for(int i=0; i<9; i++){
        for(int j=i+1;j<9;j++){
            if(sum - (dwarf[i]+dwarf[j])==100){
                a=i; b=j;
            }
        }
        
    }
    for(int k=0; k<9; k++){
        if(k==a || k==b){
            continue;
        }
        cout << dwarf[k] << '\n';
    }
    
    
}
    
