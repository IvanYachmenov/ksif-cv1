package steganografia;

import java.util.Random;

public class SteganographyFromCSR {
    static final String TSA = "abcdefghijklmnopqrstuvwxyz";
    static final Random rnd = new Random(System.currentTimeMillis());

    public static String writeOdd(String X) {
        StringBuilder Y = new StringBuilder();
        String[] words = X.split(" ");
        int detect_six = 0;

        for(String word : words) {
            StringBuilder w = new StringBuilder(word);
            w = w.reverse();
            for(char ch :  w.toString().toCharArray()) {
                detect_six++;
                char[] tmp = new char[3];
                tmp[0] = TSA.charAt(rnd.nextInt(TSA.length()));
                tmp[1] = ch;
                tmp[2] = TSA.charAt(rnd.nextInt(TSA.length()));
                Y.append(tmp);
                if (detect_six %2 == 0) {
                    Y.append(" ");
                }
            }
            Y.append(" ");
            Y.append(TSA.charAt(rnd.nextInt(TSA.length())));
            Y.append(" ");
        }
        return Y.toString().trim();
    }

    public static String readOdd(String Y) {
        StringBuilder X = new StringBuilder();
        String[] parts = Y.split(" ");
        StringBuilder tmp = new StringBuilder();

        for(String p : parts) {
            if (p.length() % 3 ==0) {
                char x1 = p.charAt(1);
                tmp.append(x1);

                if (p.length() % 6 == 0) {
                    char x2 = p.charAt(4);
                    tmp.append(x2);
                }
            } else {
                X.append(tmp.reverse().append(" "));
                tmp = new StringBuilder();
            }

        }
        return X.toString();
    }

    public static String writeEven(String X) {
        StringBuilder Y = new StringBuilder();
        X = X.replaceAll(" ", "");
        int detect_six = 0;
        for (char ch : X.toCharArray()) {
            detect_six++;
            char[] tmp = new char[3];
            tmp[0] = TSA.charAt(rnd.nextInt(TSA.length()));
            tmp[1] = ch;
            tmp[2]= TSA.charAt(rnd.nextInt(TSA.length()));
            Y.append(tmp);
            if(detect_six % 2 == 0 && ch != X.charAt(X.length()-1)) {
                Y.append(" ");
            }
        }

        return Y.toString();
    }

    public static String readEven(String Y) {
        StringBuilder X = new StringBuilder();
        Y = Y.replaceAll(" ", "");

        for (int i = 1; i < Y.length(); i += 3) {
            X.append(Y.charAt(i));
        }
        return X.toString();
    }

}
