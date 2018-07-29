package src.jwt;

import java.nio.charset.Charset;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class JWTverification {
	public static void main(String... args) {
		String token =  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.xotcRmfZTrvDmCuyyLmodmcrIDaTJ_G4Ph0kw4O5ia4";
		verifyToken(token);
		System.out.println(encrpyt("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ", "kutta"));
	}
		private static void decodeBase64(String encoded){
			byte[] valueDecoded = 	Base64.decodeBase64(encoded);
			System.out.println("Decoded value is " + new String(valueDecoded));
		}
		
		private static void encodeBase64(String decoded){
			byte[] valueEncoded = 	Base64.encodeBase64(decoded.getBytes());
			System.out.println("Decoded value is " + new String(valueEncoded));
		}
		
		private static String encrpyt(String value, String key){
			String hash = null;
			try {
				Charset cs=Charset.forName("US-ASCII");
				Mac mac = Mac.getInstance("HmacSHA256");
				SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(cs), mac.getAlgorithm());
				mac.init(secret_key);

				 hash = Base64.encodeBase64String(mac.doFinal(value.getBytes(cs)));//.replace("=", "").replace("+","-").replace("/","_").trim();
				return hash;
			} catch (Exception e) {	
				System.out.println("Error");
				
			}
			return hash;
		}
		private static boolean verifyToken(String jwtToken){
			String str = jwtToken.replace(".", ",");
			String[] jwtTokenarray=str.split(",");
			String header = jwtTokenarray[0];
			String payload = jwtTokenarray[1];
			String signature = jwtTokenarray[2];
			System.out.println(signature);
			String value = header+"."+payload;
			String secret = "kutta";
			String signatureEncryption  = new String(encrpyt(value, secret));
			System.out.println(signatureEncryption);
			if(signature.equals(signatureEncryption)){
				System.out.println("Token verified");
				return true;
				}
			else
				System.out.println("Token Invalid");
			return false;
		}
}
