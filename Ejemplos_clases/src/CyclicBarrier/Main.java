package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {
		// Parametros 
		final int ROWS = 10000;				// filas
		final int NUMBERS = 1000;			// columnas
		final int SEARCH = 5;				// buscadores
		final int PARTICIPANTS = 5;			// hilos
		final int LINES_PARTICIPANT = 2000;	// cantidad de elementos por hilo
		
		/* 	incio la matriz con las filas y las columnas y los buscadores
		 * 	_ de aqui ya tenemos cuantas coincidencias hay.
		 * 
		 */
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		
		/* arreglo de los resultados
		 * _ Sirve como buffer para guardar la cantidad de coincidencia por fila
		 */
		Result results = new Result(ROWS);
		
		/* 
		 * _ Esta es la accion que se ejecutará luego de la sincronuizacion de los hilos
		 * _ Tendremos todos los datos de las coincidencias
		 * 
		 * */
		Grouper grouper = new Grouper(results);
		
		/*
		 * _ Instanciamos una barrear ciclica con los que se sincronizaran y la accion uego de la sincronizacion
		 * _	Luego de la sincronizACION DE LOS PARTICIAONTES se ejecuta grouper
		 * 
		 */
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,grouper);
		
		/*
		 * 	Coleccion del los buscadores
		 */
		Searcher searchers[] = new Searcher[PARTICIPANTS];
		
		/*
		 * 	_incializamos los parametros de cada buscador y los lanzamos a traves de un hilo
		 */
		for(int i=0; i<PARTICIPANTS; i++) {
			searchers[i] = new Searcher(i*LINES_PARTICIPANT, (i*LINES_PARTICIPANT)+LINES_PARTICIPANT,
					mock, results, 5, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		System.out.printf("Main: The main thread has finished.. \n");
	}

}
