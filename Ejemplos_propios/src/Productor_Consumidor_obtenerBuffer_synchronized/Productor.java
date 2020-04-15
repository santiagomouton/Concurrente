package Productor_Consumidor_obtenerBuffer_synchronized;

public class Productor implements Runnable {

	 private Buffer buffer;

	    public Productor(Buffer buffer) { 
	    	super();
	    	this.buffer = buffer;
	    }

	    @Override
	    public void run() { 
	    	int cant = 0;
	    	while (cant < 100) {
	    		buffer.poner();
	    		cant++;
	    	}
	    }
}
