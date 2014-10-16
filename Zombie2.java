import java.util.ArrayList;
public class Zombie2 {
    String name;
    int serial;
    static int count = 0;
    
    private static ArrayList<Zombie> list = new ArrayList<Zombie>();
    
    Zombie2(String name) {
        list.add(this);
        this.name = name;
        serial = count;
        count++;
    }
    
    private static int getCount() {
        return list.size();
    }
    
    private Zombie2 getZombie(int i) {
        
    }
    
    static void printStatus() {
        System.out.println("Zombies created so far: " + getCount());
    }
    
    void printZombie() {
        System.out.println(name + " is zombie " + serial);
    }
}