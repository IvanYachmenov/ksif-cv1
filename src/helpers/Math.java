package helpers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Math {

    public static boolean isPrime(int input) {
        if (input < 2 || input % 2 == 0) {
            return false;
        }

        for(int i = 3; i * i <= input; i += 2) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }

    public static void gen_random() {
        int rnum;
        Random rnd = new Random(System.currentTimeMillis());
        do{
            //num = rnd.nextInt(3,101);
            rnum = rnd.nextInt(98) + 3;
            System.out.println(rnum);
        } while (!isPrime(rnum));
    }

    public static void gen_random_prime() {
        int count;
        int prime;
        int rnum;
        Random rnd = new Random(System.currentTimeMillis());
        for (prime = 0, count = 0; prime < 10; count++) {
            rnum = rnd.nextInt(98) + 3;
            if (isPrime(rnum)) {
                System.out.println(rnum);
                prime ++;
            }
        }
        System.out.println("Total: " + count);
    }

    public static void gen_random_char() {
        Random rnd = new Random(System.currentTimeMillis());
        List<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < 26; i++) {
            chars.add((char) ('a' + rnd.nextInt(26)));
            System.out.println(chars.get(i));
        }

        Collections.sort(chars);
        System.out.println(chars);
        System.out.println(chars.stream().distinct().toArray().length);
    }


    public static void main(String[] args) {
        gen_random_char();
    }

}
