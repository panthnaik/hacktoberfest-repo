#include<iostream>
using namespace std;
public:  class A {
   
    friend class B {
      public: int num;
      public: void getdata(int n) 
    {
         num = n;
      }
      void putdata() {
         cout<<"The number is "<<num;
      }
   };
};
int main() {
   cout<<"Nested classes in C++"<< endl;
   A :: B obj;
   obj.getdata(9);
   obj.putdata();
   return 0;
}
