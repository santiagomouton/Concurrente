package semaphore_with_reentranLock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// cola de impresiones
		PrintQueue printQueue = new PrintQueue();
		
		// hilos que van a imprimir
		Thread thread[] = new Thread[10];
		
		// creamos los hilos
		for(int i=0; i<10; i++) {
			thread[i] = new Thread(new Job(printQueue), "thread" + i);
		}
		
		// lanzamos los hilos
		for(int i=0; i<10; i++) {
			thread[i].start();
		}
	}

}
