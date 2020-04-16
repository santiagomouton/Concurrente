package semaphore_with_reentranLock;

public class Job implements Runnable {
	
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		super();
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		
		System.out.println();
		System.out.printf("%s: Yendo a imprimir un trabajo", 
				Thread.currentThread().getName());
		
		
		printQueue.printJob(new Object());
		
		System.out.println();
		System.out.printf("%s: EL documento ha sido impreso", 
				Thread.currentThread().getName());
		System.out.println();
	}
	
	
	
}
