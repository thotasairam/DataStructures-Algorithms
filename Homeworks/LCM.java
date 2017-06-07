import java.util.*;

public class LCM {
  private static long lcm_naive(long a, long b) {
    long gcd = 0;
    long multiplier = 0;

    if(a>b){
      gcd = gcd_naive(a,b);
      multiplier = a/gcd;
      return multiplier*b;
    }
    else {
      gcd = gcd_naive(b,a);
      multiplier = b/gcd;
      return multiplier*a;
    }

  }

  private static long gcd_naive(long a, long b) {
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
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    System.out.println(lcm_naive(a, b));
  }
}
