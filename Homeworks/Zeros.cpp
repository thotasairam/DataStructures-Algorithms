 // Finding zeros

 #include <iostream>
 using namespace std;

 int main()
 {
        double a11;
        double a12;
        double a21;
        double a22;
        double c1;
        double c2;
        double X1;
        double X2;
    
        cout <<"Solution for X1 and X2 for equations: " << endl;
        cout << "a11*X1 + a12*X2 = c1 and a21*X1 + a22*X2 = c2" << endl;
    
        cout << "Enter a value for 'a11': " <<endl;
        cin >> a11;
    
        cout << "Enter a value for 'a12': " <<endl;
        cin >> a12;
    
        cout << "Enter a value for 'c1': " << endl;
        cin >> c1;
    
        cout << "Enter a value for 'a21': " <<endl;
        cin >> a21;
    
        cout << "Enter a value for 'a22': " <<endl;
        cin >> a22;
    
        cout << "Enter a value for 'a11': " <<endl;
        cin >> c2;
    
        X1 = ((c1*a22) - (c2*a12))/((a11*a22)-(a12*a21));
        X2 = ((c2*a11)-(c1*a21))/((a11*a22)-(a12*a21));
    
        cout << "Results: X1 = " << X1 << endl;
        cout << " and X2 = " << X2 << endl;
     
        return 0;
}