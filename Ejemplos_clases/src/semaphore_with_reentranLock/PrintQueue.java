package semaphore_with_reentranLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue{

	private final Semaphore semaphore;
	
	private boolean freePrinters[];
	
	private Lock lockPrinters;

	public PrintQueue() {
		// creamos el semaforo
		semaphore = new Semaphore(3);
		// creamos el estado de las impresoras
		freePrinters = new boolean[3];
		// cargammos el estado de las impresoras con: libre
		for(int i=0; i<3; i++) {
			freePrinters[i] = true;
		}
		
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object document) {
		try {
			// decremetno en uno la cantidad de recursos disponibles
			semaphore.acquire();
			
			/*
			 * Si bien ya decremente los recursos, 
			 * en getPrinter necesito hacer un lock para que ningun otro hilo
			 * pueda obtener una impresora hasta que el hilo que entro
			 * haya obntenido una
			 */
			int assignedPrinter = getPrinter();
			
			Long duration=(long)(Math.random()*3);
			System.out.println();
			System.out.printf("%s: imprimiendo un trabajo durante %d segundos", 
					Thread.currentThread().getName(), duration);
			System.out.println();
			TimeUnit.SECONDS.sleep(duration);
			
			freePrinters[assignedPrinter] = true;
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			
			semaphore.release();
		}
	}

	private int getPrinter() {
		// TODO Auto-generated method stub
		int ret = -1;
		
		try {
			lockPrinters.lock();
			
			for(int i=0; i<freePrinters.length; i++) {
				if(freePrinters[i]) {
					ret=i;
					freePrinters[i]=false;
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lockPrinters.unlock();
		}
		
		return ret;
	}
	
}
