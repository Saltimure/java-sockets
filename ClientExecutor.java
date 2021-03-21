package chat;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientExecutor {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client("127.0.0.1",8000);
		client.sendMessage("qweqwe");
	}
}
