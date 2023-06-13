package demotcpserverdate.exercise3;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.net.ServerSocket;
import java.net.Socket;

import demotcpserverdate.serverdate.ServerDateFrame;

public class TextProcessingServer {
	public static void main(String[] args) throws IOException{

		// Launch the server frame
		ServerDateFrame serverFrame = new ServerDateFrame();
		serverFrame.setVisible(true);
				
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
				
		TextProcessing textprocessing = new TextProcessing();
		
		// counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// server needs to be alive forever
		while(true) {
			
			// message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			// accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// generate int number
			String number = textprocessing.getNumOfText();
			
			// create stream to write data on the network
			DataOutputStream outputStream =
					new DataOutputStream(clientSocket.getOutputStream());
			
			// send current date back to the client
			outputStream.writeBytes(number);
			
			// close the socket
			clientSocket.close();
			
			// update the request status
			serverFrame.updateRequestStatus("Data sent to the client: " + number);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
		}
	}
}