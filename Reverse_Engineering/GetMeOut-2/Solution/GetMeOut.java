import java.util.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class GetMeOut2 {
    public static void main(String args[]) {
        GetMeOut2 obj = new GetMeOut2();
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter username: ");
        String user = sc.next();
		if(!user.equals("admin")) {
			System.out.println("Not a Admin account");
			return;
		}
		System.out.print("Enter password: ");
        String pass = sc.next();
		if(pass.equals("n3wP4SSw0rD")) {
			System.out.println("Cams Disabled");
			System.out.println(obj.decrypt("IqGcsTcxVRZUB/Iyz+n+UHuZzaKsQBS1UAZGB+AhIDazWdlXiHFAfD5WCCVpa+ne", "n3wP4SSw0rD"));
		} else {
			System.out.println("Wrong credentials");
		}
   }
   
   private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
   
}