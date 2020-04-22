package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue{

	private final Semaphore semaphore;

	public PrintQueue() {
		// cuando creamos el objeto, creamos el semaforo y la cantidad de token
		semaphore = new Semaphore(3);
	}
	
	public void printJob(Object document) {
		try {
			// un hilo toma un token
			semaphore.acquire();
			
			Long duration=(long)(Math.random()*3);
			
			System.out.printf("%s: imprimiendo un trabajo durante %d segundos", 
					Thread.currentThread().getName(), duration);
			// tiempo al realizar la tarea
			TimeUnit.SECONDS.sleep(duration);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			// hilo devuelve el token
			semaphore.release();
		}
	}
	
}
