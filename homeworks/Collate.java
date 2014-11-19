public class Collate {
    String collate(String a, String b) {
        String answer = "";
        for (int length = a.length(), n = 0; n < length; n++) {
            answer = answer + a.charAt(n) + b.charAt(n);
        }
        return answer;
    }
}