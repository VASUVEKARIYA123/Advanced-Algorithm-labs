#include <iostream>
#include <stdio.h>
#include <bits/stdc++.h>
using namespace std;

//2). find kth ranked(kth smallest element) element in an array 

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

int find(vector<int> arr,int p,int r,int k){
    int q = rpartition(arr,p,r);
    if(q==k){
        return q;
    }
    else if(k<q){
        return find(arr,p,q-1,k);
    }
    else{
        return find(arr,q+1,r,k);
    }
}


int main(){
    srand(time(0));
    int n=1000;
    // cin>>n;

    vector<int> arr(n);
    for(int i = 0 ; i < n ; i++){
        arr[i] = i;
    }
    shuffle(arr.begin(), arr.end(), default_random_engine(time(0)));

    // rqs(arr,0,n-1);
    find(arr,0,n-1,50);
    cout<<cnt<<endl;
    return 0;
}