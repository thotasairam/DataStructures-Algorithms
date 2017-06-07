 #include <iostream>
 using namespace std;
 int main()
{
        int temp1 = 0;
    
        cout << "The sum of consecutive integers from 1 to n. "<< "\n" <<"Please enter an integer value for 'n':" << endl;
        cin >> temp1;
    
        double result = (temp1*(temp1+1))/2;
    
        cout << "Result: " << result << endl;
    
        return 0;
}