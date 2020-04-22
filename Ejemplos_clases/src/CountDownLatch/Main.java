package CountDownLatch;

public class Main {

	public static void main(String[] args) {
		
		// creamos la conferencia
		VideoConference conference = new VideoConference(10);
		
		// creamos el hilo que manejará la conferencia
		Thread threadConference = new Thread(conference);
		
		// lanzamos la conferencia
		threadConference.start();
		
		// creamos los diez participantes que estaran en la conferencia
		for(int i=0; i<10; i++) {
			Participant p = new Participant(conference, "Participant" + i);
			Thread t = new Thread(p);
			t.start();
		}
	}

}
