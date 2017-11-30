package thread.demon;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		DemonTest demon = new DemonTest();

		Thread t = new Thread(demon);

		t.setDaemon(true);

		t.start();

		for (int i = 0; i <= 10; i++) {
			Thread.sleep(50);
			System.out.println("Main thread" + i);

		}
	}
}
