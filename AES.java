import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES{
	static Cipher cipher;

	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("AES");
		System.out.println("Enter the plain text:");
		String plainText = sc.nextLine( );
		String encryptedText = encrypt(plainText, secretKey);
		System.out.println("Secret Key:"+secretKey);
		System.out.println("Encrypted Text: " + encryptedText);
	}
	}

	public static String encrypt(String plainText, SecretKey secretKey)
			throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

}