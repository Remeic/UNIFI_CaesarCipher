
public class Encryptor {

	public static void main(String[] args) {
		headDescription();
		if (args.length >= 2) { 
		Cifrario cifrarium = new Cifrario(3);
			if(args[0].toLowerCase().equals("-e")) {
	    	   System.out.println("Plain Text: "+args[1]);
	    	   System.out.println("Encrypted Text: "+cifrarium.encrypt(args[1]));
			}
			else if(args[0].equals("-d")) {
	    	   System.out.println("Encrypted Text: "+args[1]);
	    	   System.out.println("Plain Text: "+cifrarium.decrypt(args[1]));
			}
        } 
        else if (args.length == 1 && args[0].toLowerCase().equals("-h")){
        	helpDescription();
    	} 
	}

	public static void headDescription() {
		System.out.println("Cifrario di Cesare - Progetto Fondamenti di Telecomunicazioni");
		System.out.println("Alunno: Giulio Fagioli Matricola: 6006222");
		System.out.println("Lanciare il programma con l'argomento -h per una breve descrizione");
	}
	
	public static void helpDescription() {
		System.out.println("Implementazione del Cifrario di Cesare");
		System.out.println("Opzioni disponibili:");
		System.out.println(" -e per cifrare il testo es:");
		System.out.println("\t java -jar cifrariocesare.jar -e unifi");
		System.out.println(" -d per decryptare il testo es:");
		System.out.println("\t java -jar cifrariocesare.jar -d aqnin");
	}
}
