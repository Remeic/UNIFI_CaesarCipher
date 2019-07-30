import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Class that implements CifrariumOperation
 * Implements the two methods by specifying their behavior for the Caesar Cipher 
 * Abstract method: init ( population of alphabet ) 
 * @author Giulio Fagioli 6006222
 *
 */
public abstract class AbstractCifrarium implements CifrariumOperation {
	List<Character> alphabet;
	int shift;
	abstract public void initAlphabet();
	
	public String encrypt(String phrase) {
		phrase = phrase.toLowerCase();
		return getShiftedPhrase(phrase,shift);
	}
	
	
	public String decrypt(String phrase) {
		return getShiftedPhrase(phrase,(-1)*shift);
	}
	
	/**
	 * Method for get the next shifted char on the alphabet list
	 * @param charPos Position of char in the alphabet list
	 * @param shift Integer number of shift
	 * @return Shifted char
	 */
	public char getShiftedChar(int charPos,int shift) {
		int shiftCalc = (charPos+shift);
		if( shiftCalc < 0) {
			shiftCalc = (charPos+shift)+this.alphabet.size();
		}
		int newPosition = shiftCalc % this.alphabet.size();
		return this.alphabet.get(newPosition);
	}
	
	/**
	 * Method for get the all the shifter char 
	 * @param phrase Text to be shifted
	 * @param shift Integer number of shift
	 * @return String with all char of phrase shifted
	 */
	public String getShiftedPhrase(String phrase, int shift) {
		List<Character> result = new ArrayList<Character>();
		char[] listOfChar = phrase.toCharArray();
		for(char element: listOfChar) {
			if(this.alphabet.contains(element)) {
				int charPos = this.alphabet.indexOf(element);
				result.add(this.getShiftedChar(charPos, shift));
			}
		}
		
		return convertToString(result);
	}
	
	private String convertToString(List<Character> shiftedResult) {
		String result = "";
		for(char c: shiftedResult) {
			result += c;
		}
		return result;
	}
}
