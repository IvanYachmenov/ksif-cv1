package cv7;

public class VigenereCipher {
    private static final int MOD = 26;
    private final String key;

    public VigenereCipher(String key){
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key is empty");
        }
        this.key = key;
    }

    public String encrypt(String plainText) {
        StringBuilder out = new StringBuilder(plainText.length());
        for (int i = 0; i < plainText.length(); i++) {
            int p = plainText.charAt(i) - 'a';
            int k = key.charAt(i % key.length()) - 'a';
            int c = (p + k) % MOD;
            out.append((char) ('a' + c));
        }
        return out.toString();
    }

    public String decrypt(String cipherText) {
        StringBuilder out = new StringBuilder(cipherText.length());
        for (int i = 0; i < cipherText.length(); i++) {
            int c = cipherText.charAt(i) - 'a';
            int k = key.charAt(i % key.length()) - 'a';
            int p = (c - k + MOD) % MOD;
            out.append((char) ('a' + p));
        }
        return out.toString();
    }
}
