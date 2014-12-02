import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
public class Stats {
    public HashMap<String, Integer> wins (BufferedReader input) throws IOException {
        String temp = "";
        int team = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (temp != null) {
            temp = input.readLine();
            if (temp != null) {
                Scanner in = new Scanner(temp);
                team = in.nextInt();
                if (team == 0) {
                    String garbage = "";
                    while ((!garbage.equals("vs")) && (in.hasNext()))
                        garbage = in.next();
                }
                String player;
                int numCurrent = 0;
                for (int i = 0; i < 5; i++) {
                    player = in.next();
                    if (map.get(player) == null)
                        map.put(player, 1);
                    else {
                        numCurrent = map.get(player);
                        map.put(player, ++numCurrent);
                    }
                }
                in.close();
            }
        }
        return map;
    }
    public String winner (HashMap<String, Integer> map) {
        int maxValue = 0;
        String maxKey = "";
        if (map != null) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = (String) entry.getKey();
                }
            }
        }
        return maxKey;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stats stats = new Stats();
        System.out.println(stats.winner(stats.wins(in)));
        in.close();
    }
}