package demotcpserverdate.exercise7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;


public class ServerTextTranslation {
	/***
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// launch the server frame
		ServerFrame serverframe = new ServerFrame();
		serverframe.setVisible(true);
		
		// Binding to a port or any other
		int portNo = 1234;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		// declaration of text translation class object
		TextTranslation texttranslation = new TextTranslation();
		
		// counter to keep track the number of requested connection
		int totalRequest = 0;

		// server need to be alive 
		while(true) {
			
			// message to indiccate server is alive
			serverframe.updateServerStatus(false);
			
			// accept client request for connection
			Socket clientSocket = serverSocket.accept();

			// get translated text
			String translatedText = texttranslation.chooseString();
			
			// create stream to write data on network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// send current data to the client
			outputStream.writeBytes(translatedText);
			
			//outputStream.flush();
			
			// close the socket
			clientSocket.close();
			
			// update the request status
			serverframe.updateRequestStatus("Data sent to the client: "+ translatedText);
			serverframe.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest);
		}
	}
}
