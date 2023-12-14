import java.util.*;
import javax.swing.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class MultipleEncryption{
	static Cipher cipher;
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
	
	public static String AES(String l2, SecretKey k3) throws Exception{
		byte[] plainTextByte = l2.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, k3);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String l3 = encoder.encodeToString(encryptedByte);
		return l3;
		}
	
	public static String XOR(int k2,String l1){
		String outputString = "";
		int len = l1.length();
		for (int i = 0; i < len; i++){
			outputString = outputString + Character.toString((char) (l1.charAt(i) ^ k2));
			}return outputString;
		}
	
	public static void main(String args[]) throws Exception{
		String input;
		int k1,k2;
		int max=26;
		int limit=15;
		String l1,l3,l4;
		try (Scanner sc= new Scanner(System.in)){
			input = JOptionPane.showInputDialog("Enter Name:");
			Random rand = new Random();
			k1 = rand.nextInt(max);
			System.out.println("Level-1 key:"+k1);
			l1 = CaesarCipher(input,k1);
			JOptionPane.showMessageDialog(null,"Level-1 Encryption:"+l1);
			
			k2 = rand.nextInt(limit);
			System.out.println("Level-2 Key:"+k2);
			String l2 = XOR(k2,l1);
			JOptionPane.showMessageDialog(null,"Level-2 Encryption:"+l2);
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey k3 = keyGenerator.generateKey();
			cipher = Cipher.getInstance("AES");
			System.out.println("Level-3 Key:"+cipher);
			l3 = AES(l2,k3);
			JOptionPane.showMessageDialog(null,"Level-3 Encryption:"+l3);

			String keySrc = "cipher";
			byte[] k4 = keySrc.getBytes();
			SecretKeySpec k44 = new SecretKeySpec(k4,"Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, k44);
			byte[] encrypted = cipher.doFinal(l3.getBytes());
			System.out.println("Level-4 Key:"+k4);
			l4 = new String(encrypted);
			JOptionPane.showMessageDialog(null,"Level-4 Encryption:"+l4);
			}
		}
	}