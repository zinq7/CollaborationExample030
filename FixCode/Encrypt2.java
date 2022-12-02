public class Encrypt2 {
    public static void main(String[] args) {
        System.out.println(encrypt("interesting", 56));
        System.out.println(decrypt("¡??s}n{{osl", 56));
    }

    public static String encrypt(String word, byte key) {
        if (key == 0 || word.length == 0) {
            return null;
        }

        for (int i = 0; i < word.length(); i++) {
            int keyLet = (key / (i + 1));
            word = word.substring(0, i) + (char)(word.charAt(i) + keyLet) + word.substring(i + 1);
            
        }
        return word;
    }

    public static String decrypt(String word, byte key) {
        if (key == 0 || word.length() == 0) {
            return null;
        }

        for (int i = 0; i < word.length(); k++) {
            int keyLet = (key / (i + 1));
            word = word.substring(0, i) + (char)(word.charAt(i) - keyLet) + word.substring(i + 1);
            
        }
        return word;
    }
}
