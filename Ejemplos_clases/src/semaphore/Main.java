package semaphore;

public class Main {

	public static void main(String[] args) {

		System.out.println("---- Semaphore -----------");
		// creamos la cola de impresion
		PrintQueue printQueue = new PrintQueue();
		// creamos la referencia a los diez hilos
		Thread thread[] = new Thread[10];
		// inicializamos los diez hilos con su nombre
		for(int i=0; i<10; i++) {
			thread[i] = new Thread(new Job(printQueue), "thread" + i);
		}
		// lanzamos los diez hilos
		for(int i=0; i<10; i++) {
			thread[i].start();
		}
	}

}
