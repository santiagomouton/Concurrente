package CyclicBarrier;

import java.util.Random;

public class MatrixMock {

	private int data[][];
	
	/*
	 * Geenramos los numeros aleatorios y comporamos con number
	 * 
	 * parametros
	 * 	- size: int 		- 	filas
	 * 	- lenght : int		-   columans
	 * 	- number : int 		-	numero a buscar
	 */
		
	public MatrixMock(int size, int length, int number) {
		// TODO Auto-generated constructor stub
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<length; j++) {
				/*Generamos los numeros aleatorios*/
				data[i][j] = random.nextInt(10);
				/* verificamos si es igual al numero a buscar*/
				if(data[i][j] == number) {
					counter++;
				}
			}
		}
		
		System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number);
		
	}
	
	/*
	 * Retormnamos la fila que ha sido pedida a traves del paramtero ROW
	 */
	public int[] getRow(int row) {
		if((row>=0)&&(row<data.length)) {
			return data[row];
		}
		return null;
	}

}
