package CyclicBarrier;

public class Grouper implements Runnable {

	private Result results;
	
	public Grouper(Result results) {
		// TODO Auto-generated constructor stub
		this.results = results;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int finalResult = 0;
		System.out.printf("%s\n", Thread.currentThread().getName());
		System.out.printf("Grouper: processing results.. \n");
		int data[] = results.getData();
		
		for(int number:data) {
			finalResult+=number;
		}
		System.out.printf("Grouper: Total results.. %d\n", finalResult);
	}
	
	

}
