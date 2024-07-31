#include <iostream>
#include <stdio.h>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector <int> arr;
    for(int i=0 ; i<100 ; i++)
    {
        arr.push_back(i);
    }

    shuffle(arr.begin(), arr.end(), default_random_engine(time(0)));
    
    int max = 0;
    int cnt = 0;

    for(int i=0 ; i<100 ; i++)
    {
        if(arr[i] > max)
        {
            cout << arr[i] << " " << max << endl;
            max = arr[i];
            cnt++;
        }
    }

    cout << max << " " << cnt << endl;

    return 0;
}