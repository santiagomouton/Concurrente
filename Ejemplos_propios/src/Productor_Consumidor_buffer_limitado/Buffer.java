package Productor_Consumidor_buffer_limitado;

public class Buffer {

    private int buffer;
    private int poner;
    private int sacar;
    private int capacidad;
    private int cantidad;
    
    public Buffer(int capacidad, int poner, int sacar) {
    	
    	if( (capacidad >= sacar) && (poner > 0) ) {
    		this.capacidad = capacidad;
    		this.poner = poner;
    		this.sacar = sacar;
    		this.buffer = 0;
    		this.cantidad = 0;
    	}
    
    }

    private boolean disponible_poner() {
    	return (capacidad >= (buffer + poner) );
    }

    private boolean disponible_sacar() { 
    	return ((buffer - sacar) >= 0);
    }

    public boolean poner() {
    	cantidad++;
    	
    	if(!disponible_poner()) {
    		System.out.println();
    		System.out.printf("%s no pudo poner", Thread.currentThread().getName());
    		return false;
    	}
    	
    	buffer += poner;
    	
    	System.out.println();
    	System.out.printf("%s: puso %d - buffer %d - cantidad %s", Thread.currentThread().getName(), poner,
    			buffer, cantidad);
    	return true;
    }

    public boolean sacar() { 
    	cantidad++;
    	
    	if(!disponible_sacar()) {
    		System.out.println();
    		System.out.printf("%s no pudo sacar", Thread.currentThread().getName());
    		return false;
    	}
    	
    	buffer -= sacar;
    	
    	System.out.println();
    	System.out.printf("%s: saco %d - buffer %d - cantidad %s", Thread.currentThread().getName(), sacar,
    			buffer, cantidad);
    	return true;
    }    
	
}
