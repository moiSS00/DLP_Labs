package parser;

public class LexerHelper {

	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}


	// TODO: Implement the lexemeToChar and lexemeToReal methods

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		try {
			String aux = str.replace("'","");
			if(aux.length() == 1){
				return aux.charAt(0);
			}
			else {
				aux = aux.replace("\\","");

				if(aux.equals("n")){
					return '\n';
				}
				else if(aux.equals("t")){
					return '\t';
				}
				else{
					return (char) Integer.parseInt(aux);
				}
			}
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return Character.MIN_VALUE;
	}

}
