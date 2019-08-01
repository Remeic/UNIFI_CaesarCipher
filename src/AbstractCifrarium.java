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
		String result = "Can't crypt this phrase - Contains invalid char";
		if(this.checkIsValidPhrase(phrase)) {
			phrase = phrase.toLowerCase();
			result = getShiftedPhrase(phrase,shift);
		}
		return result;
	}
	
	
	public String decrypt(String phrase) {
		String result = "Can't decrypt this phrase - Contains invalid char";
		if(this.checkIsValidPhrase(phrase)) {
			phrase = phrase.toLowerCase();
			return getShiftedPhrase(phrase,(-1)*shift);
		}
		return result;
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
			if(!Character.isWhitespace(element)) {
				int charPos = this.alphabet.indexOf(element);
				result.add(this.getShiftedChar(charPos, shift));
			}
			else {
				result.add(element);
			}
		}
		
		return convertToString(result);
	}
	
	/**
	 * Method for convert List of Character to String
	 * @param shiftedResult List of shifted char
	 * @return String with all character inside List
	 */
	private String convertToString(List<Character> shiftedResult) {
		String result = "";
		for(char c: shiftedResult) {
			result += c;
		}
		return result;
	}
	
	/**
	 * Method for check if all char inside phrase is contained in the alphabet
	 * @param phrase phrase to encrypt or decrypt
	 * @return False if phrase contain char that aren't contained in alphabet list, true otherwise
	 */
	private boolean checkIsValidPhrase(String phrase) {
		boolean result = true;
		for(char c: phrase.toCharArray()) {
			if( this.alphabet.indexOf(c) == -1 && !Character.isWhitespace(c)) {
				result = false;
			}
		}
		return result;
	}
}
