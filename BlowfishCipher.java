import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class BlowfishCipher {
	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			String message;
			String keySrc = "test";
			byte[] key = keySrc.getBytes();
			SecretKeySpec ks = new SecretKeySpec(key,"Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			System.out.println("Enter the plain text:");
			message = sc.nextLine( );
			cipher.init(Cipher.ENCRYPT_MODE, ks);
			byte[] encrypted = cipher.doFinal(message.getBytes());
			System.out.println("Encrypted Text:" + new String(encrypted));
			}
		}
	}