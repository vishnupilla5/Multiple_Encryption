import java.util.*;

class Caesar{
public static String CaesarCipher(String input, int k1){
		String result= new String();
		char ch1[]=input.toCharArray();
		for(int i=0; i<input.length(); i++){
			if(Character.isLetter(ch1[i])){
				if (Character.isUpperCase(input.charAt(i))){
					char ch = (char)(((int)input.charAt(i) + k1 - 65) % 26 + 65);
					result=result+ch;
				}else{
					char ch = (char)(((int)input.charAt(i) + k1 - 97) % 26 + 97);
					result=result+ch;
					}
			}else if(ch1[i]==' '){
				char ch = ch1[i];
				result=result+ch;
				}
			}return result;
		}

public static void main(String args[]) throws Exception{
		String input;
		int k1;
		int max=26;
		String l1;
		try (Scanner sc= new Scanner(System.in)){
			System.out.print("Enter Plain text:");
			input = sc.nextLine( );
			Random rand = new Random();
			k1 = rand.nextInt(max);
			System.out.println("Key:"+k1);
			l1 = CaesarCipher(input,k1);
			System.out.println("Encrypted Text:"+l1);
}
}
}