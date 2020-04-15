package Productor_Consumidor_buffer_limitado;

public class Productor implements Runnable {

	 private Buffer buffer;

	    public Productor(Buffer buffer) { 
	    	super();
	    	this.buffer = buffer;
	    }

	    @Override
	    public void run() { 
	    	while(true) {
	    		if (!buffer.poner()) {
	    			try {
	    				Thread.sleep(0);
	    			}catch(InterruptedException ex) {}
	    		}
	    	}
	    }
}
