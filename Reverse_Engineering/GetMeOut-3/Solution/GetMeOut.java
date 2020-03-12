import java.util.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class GetMeOut3 {
    public static void main(String args[]) {
        GetMeOut3 obj = new GetMeOut3();
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter username: ");
        String user = sc.next();
		if(!user.equals("admin")) {
			System.out.println("Not a Admin account");
			return;
		}
		System.out.print("Enter password: ");
        String pass = sc.next();
		if(check(pass)) {
			System.out.println("Cams Disabled");
			System.out.println(obj.decrypt("ZVHKfUR4i3FsWaNE0yRmSnL43FkhBfGEswK/AWu1BTTn+8Xy37IIVJ6ShxIJlVH0", pass));
		} else {
			System.out.println("Wrong credentials");
		}
   }
   
   private static boolean check(String pass) {
	   if(pass.length()!=28)
		   return false;
	   char[] passarr=pass.toCharArray();
	   int[] pass2={112,108,5,87,123,5,87,123,105,20,119,80,123,119,23,103,81,118,65,123,116,100,119,119,115,20,118,96};
	   for(int i=0;i<28;i++) {
		   passarr[i]=(char)(passarr[i]^0x24);
		   if(passarr[i]!=pass2[i])
			   return false;
	   }
	   return true;
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