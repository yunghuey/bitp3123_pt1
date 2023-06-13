package demotcpclientdate.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import demotcpclientdate.clientdate.ClientDateFrame;


public class TextProcessingClient {
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		TextFrameClient clientDateFrame = new TextFrameClient();
		clientDateFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientDateFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current date
		String currentDate = bufferedReader.readLine();
		clientDateFrame.updateServerDate(currentDate);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}
}
