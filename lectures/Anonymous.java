abstract public class Anonymous {
    static int x = 5;
    int y = 11;
    public static void main(String[] args) {
        x+= 1;
        final int z = 42;
        Anonymous a = new Anonymous() {
            void doit() {
                y += 1;
                System.out.println(x);
                System.out.println(y);
                System.out.println(z);
            }
        };
        x += 1;
        a.doit();
    }
    abstract void doit();
}