#include <bits/stdc++.h>

using namespace std;

bool solution(vector<string> phone_book) {
    sort(phone_book.begin(), phone_book.end());
    for (int i = 0; i < phone_book.size() - 1; i++) {
        string s1 = phone_book[i];
        string s2 = phone_book[i + 1];
        if (s1.size() > s2.size()) continue;
        string s3 = s2.substr(0, s1.size());
        if (s1 == s3) return false;
    }
    return true;
}