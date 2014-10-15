public class Zombie {
    String name;
    int serial;
    static int count = 0;
    
    Zombie(String name) {
        this.name = name;
        serial = count;
        count++;
    }
    
    static void printStatus() {
        System.out.println("Zombies created so far: " + count);
    }
    
    void printZombie() {
        System.out.println(name + " is zombie " + serial);
    }
}
    