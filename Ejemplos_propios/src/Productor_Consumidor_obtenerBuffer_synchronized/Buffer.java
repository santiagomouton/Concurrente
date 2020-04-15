package Productor_Consumidor_obtenerBuffer_synchronized;


public class Buffer {
	
	private boolean disponible;
    
	public Buffer() { 
		// no esta disponible para sacar
		disponible = false;
    }

    private boolean is_disponible() {
    	return disponible;
    }

    public synchronized void poner() {
    	while(is_disponible()) {
    		try {
    			mensaje_esperando(Thread.currentThread().getName());
    			wait();
    		}catch(InterruptedException ex) {}
    	}
    	    	
    	try {
    		mensaje_haciendo(Thread.currentThread().getName());
			Thread.sleep(100);
		}catch(InterruptedException ex) {}
    	
    	disponible = true;
    	notify();
    	//notifyAll();
    }

    public synchronized void sacar() { 
    	while(!is_disponible()) {
    		try {
    			mensaje_esperando(Thread.currentThread().getName());
    			wait();
    		}catch(InterruptedException ex) {}
    	}
    	    	
    	try {
    		mensaje_haciendo(Thread.currentThread().getName());
			Thread.sleep(100);
		}catch(InterruptedException ex) {}
    	
    	disponible = false;
    	notify();
    	//notifyAll();
    }
    
    private void mensaje_esperando(String mensaje) {
    	System.out.printf("-------------------------");
    	System.out.println();
    	System.out.printf("%s esperando ", mensaje );
		System.out.println();
    }
	
    private void mensaje_haciendo(String mensaje) {
    	System.out.println();
    	System.out.printf("%s haciendo ", mensaje );
		System.out.println();
    }
}
