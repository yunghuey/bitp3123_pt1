package demotcpserverdate.exercise7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTextTranslation {
		
	public static void main(String[] args) throws UnknownHostException, IOException{
			
		// Launch client-side frame
		ClientFrame clientframe = new ClientFrame();
		clientframe.setVisible(true);
		
		// Connect to the server @localhost, port 1234
		Socket socket = new Socket(InetAddress.getLocalHost(),1234);
		
		// Update the status of connection
		clientframe.updateConnectionStatus(socket.isConnected());
		
		// read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// display the translated text
		String translatedText = bufferedReader.readLine();
		clientframe.updateText(translatedText);
		
		// close everything 
		bufferedReader.close();
		socket.close();		
		}
	}