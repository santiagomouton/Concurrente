package semaphore;

public class Job implements Runnable {
	
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		super();
		// TODO Auto-generated constructor stub
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Yendo a imprimir un trabajo", 
				Thread.currentThread().getName());
		System.out.println();
		
		printQueue.printJob(new Object());
		
		System.out.println();
		System.out.printf("%s: EL documento ha sido impreso", 
				Thread.currentThread().getName());
		System.out.println();
	}
	
	
	
}
