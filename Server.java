package chat;
/* This is a server class, that receive a port in constructor
 * and have a connection method where connects with a
 * clientSocket by using method .accept();
 */
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Server {
	private ServerSocket serverSocket;
	private BufferedReader buffReader;
	private String request;
	private Socket clientSocket;
	
	public Server(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
	}
	/* this method wait for the connection (.accept())
	 * and then read received data from clientSocket
	 */
	public void connection() throws IOException {
		while(true) {
			this.clientSocket = this.serverSocket.accept();
			this.buffReader = new BufferedReader(
					new InputStreamReader(
							this.clientSocket.getInputStream()
							)
					);
			this.request = this.buffReader.readLine();
			System.out.println(this.request);
			this.buffReader.close();
			this.clientSocket.close();
		}
	}
}
