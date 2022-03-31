package tcpclientserver;


/**
 * This class generates words.
 * 
 * @author Nur Izzati binti Ishak
 *
 */
public class WordGenerator {

	
	/**
	 * This method generates word and the length of the word generated.
	 * 
	 * @return length of the text.
	 */
	
public String getWord() {
		
		String text = "Nur Izzati binti Ishak B032010122 2 BITS S1G1";
		String length = String.valueOf(count(text));
		
		return length;
		
	}

	public static int count(String text) {
		// TODO Auto-generated method stub
		if(text == null || text.isEmpty()) {
			return 0;
		}
		
		String [] word = text.split("\\s+");
		return word.length;
	}
}