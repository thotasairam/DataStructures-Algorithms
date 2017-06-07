import java.util.*;

public class GCD {
  private static long gcd_naive(long a, long b) {
//    int current_gcd = 1;
//    for(int d = 2; d <= a && d <= b; ++d) {
//      if (a % d == 0 && b % d == 0) {
//        if (d > current_gcd) {
//          current_gcd = d;
//        }
//      }
//    }

    if(b == 0){
      return a;
    }
    else {
      long ap = a % b;
      return gcd_naive(b, ap);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    if(a>b) {
      System.out.println(gcd_naive(b, a));
    }
    else {
      System.out.println(gcd_naive(a,b));
    }
  }
}
