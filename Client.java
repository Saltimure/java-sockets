package chat;
/* This is a Client class that sends data to
 * serverSocket by using stream
 */
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Client {
	private Socket clientSocket;
	private OutputStreamWriter outWriter;
	private String request;
	
	public Client(String ip, int port) throws UnknownHostException, IOException {
		this.clientSocket = new Socket(ip,port);
	}
	
	public void sendMessage(String request) throws IOException {
		this.request = request;
		this.outWriter = new OutputStreamWriter(clientSocket.getOutputStream());
		this.outWriter.write(this.request + " \n");
		this.outWriter.flush();
		this.outWriter.close();
		this.clientSocket.close();
	}
}
