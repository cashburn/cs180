import java.util.Scanner;
class Nirvana extends Thread {
    public boolean enlightenment = false;
    public void run() {
        meditate();
    }
 
	synchronized void meditate() {
		try {        
			while (!enlightenment) {
	            System.out.println("Om...");
				wait();
        	}
		}
		catch (InterruptedException e) {};
    }
	
    synchronized void enlighten() throws InterruptedException {
        enlightenment = true;
		notify();
    }
    public static void main(String[] args) throws InterruptedException {
        Nirvana t = new Nirvana();
        t.start();
        Scanner s = new Scanner(System.in);
        s.nextLine();
        t.enlighten();
        t.join();
    }
}
