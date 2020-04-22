package CountDownLatch;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

	private VideoConference Conference;
	private String name;
	
	
	public Participant(VideoConference Conference, String name) {
		super();
		this.Conference = Conference;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Long duration = (long)(Math.random()*10);
		
		try {
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Conference.arrive(name);
	}

}
