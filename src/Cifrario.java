import java.util.ArrayList;
import java.util.Arrays;

public class Cifrario extends AbstractCifrarium {
	
	public Cifrario(int shift) {
		super();
		this.alphabet = new ArrayList<Character>();
		this.shift = shift;
		this.initAlphabet();
	}

	/**
	 * Init method populate alphabet with the italian alphabet
	 */
	@Override
	public void initAlphabet() {
		this.alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','l','m','n','o','p','q','r','s','t','u','v','z');
	}

	
}
