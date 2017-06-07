import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(long[] numbers) {

        int n = numbers.length;
        int max1Index = 0, max2Index = 0;
        long temp = numbers[0];

        for (int i = 0; i < n; i++) {
            if(numbers[i] >= temp){
                temp = numbers[i];
                max1Index = i;
            }
        }

        temp = numbers[0];

        for(int i= 0; i < n; i++){
            if( i != max1Index && numbers[i] >= temp){
                temp = numbers[i];
                max2Index = i;
            }
        }

        if(n!= 2) {
            return numbers[max1Index] * numbers[max2Index];
        }
        else{
            return numbers[0] * numbers[1];
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();

        //Constraints
        if( n < 2 || n > (2*Math.pow(10,5))){
            System.out.println("Invalid 'n' = "+ n +"!");
            System.exit(0);
        }

        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();

            //Constraints
            if(numbers[i] < 0 || numbers[i] > Math.pow(10,5)){
                System.out.println("Invalid numbers[" + i + "] =" + numbers[i] + "!");
                System.exit(0);
            }
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}