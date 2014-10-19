public class Die {
    public static double rand;
    public int roll() {
        rand = Math.random();
        
        for (double i = 0; i <= 5; i++) {
            if (((i / 6.0) <= rand) & (rand < ((i + 1) / 6.0)))
                return (int) (i + 1);
        }
        /*if ((0 <= rand) & (rand < (1/6)))
            return 1;
        if (((1.0/6.0) <= rand) & (rand < (1/3)))
            return 2;
        if (((1/3) <= rand) & (rand < (1/2)))
            return 3;
        if (((1/2) <= rand) & (rand < (2/3)))
            return 4;
        if (((2/3) <= rand) & (rand < (5/6)))
            return 5;
        if (((5/6) <= rand) & (rand < 1))
            return 6;*/
        return 0;
    }
    public static void main(String[] args) {
        Die d = new Die();
        WeightedDie d1 = new WeightedDie();
        for (int i = 0; i < 25; i++) 
            System.out.println(d.roll());
        for (int i = 0; i < 25; i++) 
            System.out.println(d1.roll());
    }
}

class WeightedDie extends Die {
    public int roll() {
        rand = Math.random();
        
        if (rand < 0.5)
            return super.roll();
        //else
        return 6;
        
    }
}