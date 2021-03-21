package chat;

import java.io.IOException;

public class ServerExecutor {

	public static void main(String[] args) throws IOException {
		Server server = new Server(8000);
		server.connection();
	}
}
