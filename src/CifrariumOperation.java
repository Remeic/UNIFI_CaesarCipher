

/**
 * Interface that declare encrypt and decrypt signs method
 * All Cifrarium must implement this interface
 * @author Giulio Fagioli 6006222
 *
 */
public interface CifrariumOperation {
	/**
	 * Method for encrypt the text
	 * @param phrase ( Plain Text )
	 * @return Encrypted text
	 */
	public String encrypt(String phrase);
	
	/**
	 * Method for decrypt the text
	 * @param phrase ( Encrypted Text )
	 * @return Decrypted - Plain Text
	 */
	public String decrypt(String phrase);
}
