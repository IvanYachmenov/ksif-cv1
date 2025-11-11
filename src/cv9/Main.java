package cv9;

public class Main {
    private static void printBlock(String original, String encrypted, String decrypted) {
        System.out.println("Original:  " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println();
    }

    private static void testDCT(DoubleColumnarTransposition dct, String text) {
        String enc = dct.encrypt(text);
        String dec = dct.decrypt(enc);
        printBlock(text, enc, dec);
    }

    private static void testSTP(STPCipher stp, String text) {
        String enc = stp.encrypt(text);
        String dec = stp.decrypt(enc);
        printBlock(text, enc, dec);
    }

    public static void main(String[] args) {
        //
        System.out.println("Double Columnar Transposition Tests");
        DoubleColumnarTransposition dct1 = new DoubleColumnarTransposition("keyone", "keytwo");
        DoubleColumnarTransposition dct2 = new DoubleColumnarTransposition("zebra", "monkey");
        DoubleColumnarTransposition dct3 = new DoubleColumnarTransposition("crypto", "graph");

        testDCT(dct1, "abc");
        testDCT(dct2, "aaabbbccc");
        testDCT(dct3, "attack at dawn");



        //
        System.out.println("STP Cipher Tests");
        Character[] masKey = new Character[]{
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };

        STPCipher stp1 = new STPCipher(masKey, "secret", "message");
        STPCipher stp2 = new STPCipher(masKey, "alpha",  "beta");
        STPCipher stp3 = new STPCipher(masKey, "plain",  "key");

        testSTP(stp1, "abc");
        testSTP(stp2, "aaabbbccc");
        testSTP(stp3, "thisisatest");
    }
}
