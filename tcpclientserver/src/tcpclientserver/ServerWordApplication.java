package tcpclientserver;


/**
 * This class generates words.
 * 
 * @author Nur Izzati binti Ishak
 *
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerWordApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerWordFrame serverFrame = new ServerWordFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		//DateGenerator dateGenerator = new DateGenerator();
		WordGenerator wordGenerator = new WordGenerator();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Generate current text length
			
			String text = wordGenerator.getWord();
			
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current date back to the client
			outputStream.writeBytes(text);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Word length count sent to the client: " + text);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		

	}

}
