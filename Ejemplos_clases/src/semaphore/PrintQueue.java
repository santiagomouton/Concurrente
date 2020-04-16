package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue{

	private final Semaphore semaphore;

	public PrintQueue() {
		semaphore = new Semaphore(3);
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			
			Long duration=(long)(Math.random()*3);
			
			System.out.printf("%s: imprimiendo un trabajo durante %d segundos", 
					Thread.currentThread().getName(), duration);
			
			TimeUnit.SECONDS.sleep(duration);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			
			semaphore.release();
		}
	}
	
}
