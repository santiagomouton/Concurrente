package Productor_Consumidor_buffer_limitado;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer(100, 20, 15);
		
		Consumidor consumidor = new Consumidor(buffer);
		Productor productor = new Productor(buffer);
		
		Thread hc = new Thread(consumidor);
		Thread hp = new Thread(productor);
		
		hc.setName("Thread Consumidor 1");
		hp.setName("Thread Productor");
		
			hp.start();
			hc.start();
	}

}
