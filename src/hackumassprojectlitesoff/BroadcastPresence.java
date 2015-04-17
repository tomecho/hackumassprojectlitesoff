package hackumassprojectlitesoff;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Date;

//Author Thomas Peck
public class BroadcastPresence implements Runnable{
	private Thread t;
	public BroadcastPresence(){
		System.out.println("broadcasting presence to users");
		if (t != null) return;
		t = new Thread(this, "broadcaster");
		t.start();
	}
	public void Broadcast(){
		DatagramSocket s = null;
		try{
			try {
				s = new DatagramSocket();
				s.setBroadcast(true);
			} catch (SocketException e) {
				e.printStackTrace();
				return;
			}
			InetAddress broadAddress = getBroadcastAddress();
			if(broadAddress == null) {
				System.err.println("failed to get broadcast address");
				return; }
			byte[] data = "hi im a projectlitesoff hub".getBytes();
			DatagramPacket p = new DatagramPacket(data, data.length, broadAddress, 8000);
			try {
				s.send(p);
				System.out.println((char)27 + "[32mIs there anybody out there?");
			} catch (IOException e) {
				System.err.println("failed to send packet");
				e.printStackTrace();
				return;
			}
		} finally {
			s.close();
		}
	}
	public void run(){
		try{
			long next;
			while(true){
				next = (new Date().getTime()) + 1000l; //60 seconds from now
				while((new Date().getTime()) < next){
					//wait around till the now is greater than next
				}
				Broadcast();
			}
		} finally {
			
		}
	}
	public InetAddress getBroadcastAddress() {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			NetworkInterface current;
			while(interfaces.hasMoreElements()){
				current = interfaces.nextElement();
				if(current.isLoopback()) continue;
				for(InterfaceAddress a : current.getInterfaceAddresses()){
					InetAddress broadAddress = a.getBroadcast();
					if(broadAddress == null) continue;
					else return broadAddress;
				}
			}
			return null; // couldnt find any
		} catch (SocketException e) {
			return null;
		}
	}
}
