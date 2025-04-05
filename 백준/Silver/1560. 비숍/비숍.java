import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger input = new BigInteger(br.readLine());

        if(input.equals(BigInteger.ONE)) {
            System.out.println("1");
        }
        else if(input.equals(BigInteger.valueOf(2))) {
            System.out.println("2");
        }
        else {
            BigInteger answer = input.multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(2));
            System.out.println(answer);
        }
        
        br.close();
    }
}
