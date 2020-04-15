package Productor_Consumidor_buffer_limitado;

public class Consumidor implements Runnable {

	
	private Buffer buffer;

    public Consumidor(Buffer buffer) { 
    	super();
    	this.buffer = buffer;
    }

    @Override
    public void run() {
    	while(true) {
    		if( !buffer.sacar() ) {
    			try {
    				Thread.sleep(0);
    			}catch(InterruptedException ex) {}
    		}
    	}
    }
}
