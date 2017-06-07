import java.util.*;

public class HelloWorld{

public static void main (String[] args)
    {
        int i = 0;
        
        Scanner n = new Scanner(System.in);
        
        System.out.println("Enter a number");
        
        i = n.nextInt();
        
        if(i==1)
        {
            System.out.println("Hello world 1");
        }
        else if(i == 2)
        {
            
            System.out.println("HW 2");
        }
    }

}