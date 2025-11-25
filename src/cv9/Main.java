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

    static void main(String[] args) {

        //
        System.out.println("Double Columnar Transposition Tests");

        DoubleColumnarTransposition dct1 = new DoubleColumnarTransposition("predmet", "klasickesifry");
        testDCT(dct1, "testujemevaseimplementaciecivietespravnesifrovatadesifrovat");



        //
        System.out.println("STP Cipher Tests");

        Character[] masKey = new Character[]{
                'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'
        };
        STPCipher stp1 = new STPCipher(masKey, "klasicke", "sifry");
        testSTP(stp1, "testujemevaseimplementaciecivietespravnesifrovatadesifrovat");
    }
}
