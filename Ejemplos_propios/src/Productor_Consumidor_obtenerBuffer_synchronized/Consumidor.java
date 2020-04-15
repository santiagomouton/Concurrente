package Productor_Consumidor_obtenerBuffer_synchronized;

public class Consumidor implements Runnable {

	
	private Buffer buffer;

    public Consumidor(Buffer buffer) { 
    	super();
    	this.buffer = buffer;
    }

    @Override
    public void run() {
    	int cant = 0;
    	while (cant < 100) {
    		buffer.sacar() ;
    		cant++;
    	}
    }
}
