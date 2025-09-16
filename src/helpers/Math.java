package helpers;
import javax.swing.*;
import java.io.File;
import java.text.Normalizer;
import java.util.*;

public class Math {

    //1.1-1
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

    //1.1-2
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }

    //1.2
    public static void genRandom() {
        int rnum;
        Random rnd = new Random(System.currentTimeMillis());
        do{
            //num = rnd.nextInt(3,101);
            rnum = rnd.nextInt(98) + 3;
            System.out.println(rnum);
        } while (!isPrime(rnum));
    }

    //1.3
    public static void genRandomPrime() {
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

    //1.4
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

    //1.5
    public static void conversion() {
        List<String> names = Arrays.asList("Ivan", "Adam", "George");
        String[] names_array = new String[names.size()];
        names.toArray(names_array);

        System.out.println(names);
        System.out.println(Arrays.toString(names_array));
    }

    //1.6
    public static void creationDeletionStr() {
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder rand_nums = new StringBuilder();
        int num;
        for(int i = 0; i < 100; i++) {
            num = rnd.nextInt(100) + 1;
            if (num % 2 == 0) {
                rand_nums.append(num);
            }
            if (i != 99) {
                rand_nums.append(",");
            }

        }
        String regex = ",";
        String rand_nums_str = rand_nums.toString();
        String[] splitted = rand_nums_str.split(regex);
        Integer[] splitted_int = new Integer[splitted.length];

        int idx = 0;
        for(String s : splitted) {
            splitted_int[idx] = Integer.parseInt(s);
            idx++;
        }

        String back_to_unsplitted = Arrays.toString(splitted_int);
        back_to_unsplitted = back_to_unsplitted.replace("[", "");
        back_to_unsplitted = back_to_unsplitted.replace("]", "");
        System.out.println(back_to_unsplitted);
    }

    //1.7
    public static String convertToTSA(String text, boolean is_space) {
        StringBuilder sb = new StringBuilder();
        for(char letter : text.toLowerCase().toCharArray()) {
            sb.append(letter);
        }
        String lower_text = sb.toString();
        String normalized = Normalizer.normalize(lower_text, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}+", "");
        if (is_space) {
            normalized = normalized.replace(" ", "");
        }
        return normalized;
    }

    //1.8

    public static File pickFromFileChooser() {
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Choose a file . . .");

        // ... TODO)

        int f = j.showSaveDialog(null);
        if (f == JFileChooser.APPROVE_OPTION) {
            return j.getSelectedFile();
        }
        return null;
    }

    public static void main(String[] args) {
        //gen_random_char();
        //conversion();

    }

}
