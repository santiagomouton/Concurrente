package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

	// controlador de la conferencia
	private final CountDownLatch controller;	
	
	public VideoConference(int participant) {
		super();
		// creamos la instancia de controlador diciendole el valor maximo
		controller = new CountDownLatch(participant); 
	}

	public void arrive(String name) {
		// un participante arrivo a la conferencia
		System.out.println(name + " has arrived.");
		// decrementamos el contador 
		controller.countDown();
		// avisamos cuantos particiapntes faltan
		System.out.println("VideoConference: Waiting for " + controller.getCount() + " participants");
	}
	
	@Override
	public void run() {
		// Inicia la conferencia
		System.out.println("VideoConference: Inicialization: " + controller.getCount() + "participants.");
		try {
			// el controlador espera que llegune todos los participantes
			controller.await();
			System.out.println("VideoConference: All the participants have come");
			System.out.println("VideoConference: Let's start...");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}



}
