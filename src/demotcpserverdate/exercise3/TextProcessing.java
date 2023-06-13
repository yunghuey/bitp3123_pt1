package demotcpserverdate.exercise3;

public class TextProcessing {
	public String getNumOfText() {
		String words = "One Two Three Four";
		int countWords = words.split("\\s").length;
		return Integer.toString(countWords);
	}
}
