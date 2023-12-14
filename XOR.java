import java.util.*;

public class XOR {
	static String encryptDecrypt(char xorKey,String inputString){
		String outputString = "";
		int len = inputString.length();
		for (int i = 0; i < len; i++){
			outputString = outputString + Character.toString((char) (inputString.charAt(i) ^ xorKey));
			}
		return outputString;
		}
	public static void main(String[] args){
		String sampleString;
		try (Scanner sc= new Scanner(System.in)){
			System.out.println("Enter Plain text:");
			sampleString = sc.nextLine( );
			System.out.print("Enter key value:");
		    	char xorKey = sc.next().charAt(0);
		    	System.out.println("Encrypted String:"+encryptDecrypt(xorKey,sampleString)); 
		    }
		}
	}