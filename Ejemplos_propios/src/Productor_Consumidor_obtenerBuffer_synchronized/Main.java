package Productor_Consumidor_obtenerBuffer_synchronized;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Buffer buffer = new Buffer();		
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);
		
		Thread thread_c = new Thread(consumidor);
		Thread thread_p = new Thread(productor);
		
		thread_c.setName("Th-c");
		thread_p.setName("Th-p");
		/*
		Productor productor_2 = new Productor(buffer);
		Consumidor consumidor_2 = new Consumidor(buffer);
		
		Thread thread_p2 = new Thread(productor_2);
		Thread thread_c2 = new Thread(consumidor_2);
		

		thread_p2.setName("Th-p2");
		thread_c2.setName("Th-c2");
		*/
		thread_c.start();
		thread_p.start();
		//thread_p2.start();
		//thread_c2.start();
	}

}
