package hackumassprojectlitesoff;

public class BroadcastPresence implements Runnable{
	private Thread t;
	public BroadcastPresence(){
		System.out.println("broadcasting presence to users");
		if (t != null) return;
		t = new Thread(this, "broadcaster");
		t.start();
	}
	public void run(){
		while(true){
			//System.out.println("test");
			//create broadcast
		}
	}
}
