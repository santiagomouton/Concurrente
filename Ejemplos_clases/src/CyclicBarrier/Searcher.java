package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
	
	private int firstRow, lastRow, number;
	
	private MatrixMock mock;
	
	private Result results;
	
	/*
	 * Una vez sincronizados los hilos, la instanciacion que se paso por parametro de CyclicBarrier
	 * ejecutara la siguiente accion precargada en su definicion
	 */
	private  final CyclicBarrier barrier;

	public Searcher(int firstRow, int lastRow, MatrixMock mock, Result results, 
			int number, CyclicBarrier barrier ) {
		// TODO Auto-generated constructor stub
		super();
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.results = results;
		this.number = number;
		this.barrier = barrier;
	}

	/*
	 * busca desde la primer fila hasta la umtima fila.
	 * 	1_ obtiene la fila
	 *  2_ busca en cada elemento alguna coincidencia.
	 *  	2a_ caso de encontrar, incrementa el contador.
	 *  3_ terminado de buscar en la fila, guardamos el estado de las coincidencia y la fila.
	 *  	Pasamos luego a la siguiente fila. 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int counter;
		System.out.printf("%s: Procesing lines from %d to %d.\n", Thread.currentThread().getName(),
								firstRow, lastRow);
		
		for(int i=firstRow; i<lastRow; i++) {
			int row[] = mock.getRow(i);			// 1_
			counter = 0;
			for(int j=0; j<row.length; j++) {	// 2_
			
				if(row[j]==number) {			// 2a_
					counter++;
				}
			}
			results.setData(i, counter);		// 3_
		}
		
	System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
	
		try {
			/*
			 * TErmiando la busqueda de un hilo, barrier lo pone a dormir hasta que lleguen los demas hilo
			 */
			barrier.await();
			
			/*
			 * Aqui simboliza que todos los hilos se sincronizaron
			 */
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
