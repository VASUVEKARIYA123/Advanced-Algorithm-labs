#include<bits/stdc++.h>
using namespace std;

// 1). Randomized Quick sort algorithm

int cnt = 0;
void swap(vector<int> &arr,int p,int q){
    int temp = arr[p];
    arr[p] = arr[q];
    arr[q] = temp;
}

int partition(vector<int> &arr,int p ,int r){\
    int i = p-1;
    int x = arr[r];

    for(int j = p ; j < r ; j++){
        cnt++;
        if(arr[j]<=x) {
            i++;
            swap(arr,i,j);
        }
    }
    i++;
    swap(arr,i,r);
    return i;
}



int rpartition(vector<int> &arr,int p,int r){
    int ran = rand()%(r-p+1) + p;
    swap(arr,ran,r);
    return partition(arr,p,r); 
}

void rqs(vector<int> &arr,int p,int r){
    if(p<r){
        int q = rpartition(arr,p,r);
        rqs(arr,p,q-1);
        rqs(arr,q+1,r);
    }
    
}


int main(){
    srand(time(0));
    int n;
    cin>>n;

    vector<int> arr(n);
    for(int i = 0 ; i < n ; i++){
        arr[i] = i;
    }

    rqs(arr,0,n-1);
    cout<<cnt;
    return 0;
}
