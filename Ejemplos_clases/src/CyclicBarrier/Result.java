package CyclicBarrier;

public class Result {
	
	private int data[];
	
	public Result(int size) {
		// TODO Auto-generated constructor stub
		data = new int[size];
	}
	
	public void setData(int position, int value) {
		data[position] = value;
	}
	
	/* Retornamos el arrreglo del resultado */
	public int[] getData() {
		return data;
	}
}
