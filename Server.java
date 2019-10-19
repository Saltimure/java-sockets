import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;

        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Accepted " + (++count));

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    )
            );

            String request = reader.readLine();
            String response = "#" + count + ", your message lenght is " + request.length() + "\n";
            writer.write(response);
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }

        //serverSocket.close();
    }
}
