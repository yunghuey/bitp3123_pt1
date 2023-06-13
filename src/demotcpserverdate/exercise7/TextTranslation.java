package demotcpserverdate.exercise7;
import java.util.Scanner;

public class TextTranslation {
	private String[][] translate = {
			{"Selamat pagi", "صباح الخير", "좋은 아침"},
			{"Selamat malam", "طاب مساؤك", "안녕히 주무세요"},
			{"Apa khabar?", "كيف حالك؟", "어떻게 지내세요?"},
			{"Terima kasih","شكرا لك", "감사합니다"},
			{"Selamat tinggal","مع السلامة", "안녕"},
			{"Ada apa?","ما أخبارك؟","뭐야?"}
	};

	public String chooseString() {

		// choose english text
		System.out.println("1. Good morning");
		System.out.println("2. Good night");
		System.out.println("3. How are you? ");
		System.out.println("4. Thank you");
		System.out.println("5. Goodbye");
		System.out.println("6. What's up? ");
		System.out.print("Choose a text:");
		Scanner sc = new Scanner(System.in);
	    int choice1 = sc.nextInt();
	    
	    
	    if(choice1 < 1 || choice1 > 6)
	    	chooseString();
	    
	    // choose targetted language
	    System.out.println("1. Bahasa Malaysia");
	    System.out.println("2. Arabic");
	    System.out.println("3. Korean");
	    System.out.print("Choose a language to translate: ");
	    
	    int language = sc.nextInt();
	    if (language < 0 || language > 3)
	    	chooseString();
	    
	    String text = translate[choice1-1][language-1];
	    return text;
	}

}
