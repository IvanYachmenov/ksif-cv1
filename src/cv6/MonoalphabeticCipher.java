package cv6;

import static cv3.InversionPermutation.inverse;

public class MonoalphabeticCipher {

    private final Character[] key;
    private final Character[] inverseKey;

    public MonoalphabeticCipher(Character[] key) {
        if (key == null || key.length != 26) {
            throw new IllegalArgumentException("Key must have 26 letters (a..z)");
        }
        this.key = key;
        this.inverseKey = inverse(key);
    }

    public String encrypt(String plainText) {
        StringBuilder sb = new StringBuilder(plainText.length());
        for (char ch : plainText.toCharArray()) {
            int idx = ch - 'a';
            sb.append(key[idx]);
        }
        return sb.toString();
    }

    public String decrypt(String cipherText) {
        StringBuilder sb = new StringBuilder(cipherText.length());
        for (char ch : cipherText.toCharArray()) {
            int idx = ch - 'a';
            sb.append(inverseKey[idx]);
        }
        return sb.toString();
    }
}
