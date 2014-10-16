public class CaesarCipher {
    
    public static String justTheLetters(String toClean) {
        String justTheLetters = "";
        for (int i = 0; i < toClean.length(); i++) {
            if (Character.isLetter(toClean.charAt(i))) {
                justTheLetters += toClean.charAt(i);
            }
        }
        return justTheLetters.toUpperCase();
    }
    
    public static String encrypt(String plaintext, int key) {
        String cleaned = justTheLetters(plaintext);
        String encrypt = "";
        for (int i = 0; i < cleaned.length(); i++) {
            char current = (char) (cleaned.charAt(i) + key);
            char count = 0;
            while (current > 'Z') {
                current--;
                count++;
            }
            if (count > 0)
                current = (char) ('A' + (count - 1));
            encrypt += (current);
        }
        return encrypt;
    }
    
    public static String decrypt(String cipher, int key) {
        String cleaned = justTheLetters(cipher);
        String decrypt = "";
        for (int i = 0; i < cleaned.length(); i++) {
            char current = (char) (cleaned.charAt(i) - key);
            char count = 0;
            while (current < 'A') {
                current++;
                count++;
            }
            if (count > 0)
                current = (char) ('Z' - (count - 1));
            decrypt += current;
        }
        return decrypt;
    }
    
    public static int crack(String cipher) {
        String cleaned = justTheLetters(cipher);
        char max = 0;
        int countMax = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            int count = 0;
            for (int j = 0; j < cleaned.length(); j++) {
                if (cleaned.charAt(j) == i)
                    count++;
            }
            if (count > countMax) {
                countMax = count;
                max = i;
            }
        }
        char count = 0;
        char count2 = 0;
        
        while (max > 'E') {
            count++;
            max--;
        }
        while (max < 'E') {
            count--;
            max++;
        }
        return count;
    }
}
            
            
            
            
            
            
            
            
            
            
            
            
            