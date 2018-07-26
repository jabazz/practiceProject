package main.java;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class JWTdecryption {
	public static void main (String ...args) throws Exception{
		
		String jwtToken = new String("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
		String str = jwtToken.replace(".", ",");
		String[] array  ;
		array = str.split(",");
		for (String temp: array){
	          System.out.println(temp);
	       }
		
		//String header = jwtTokenarray[0];
		//String payload = jwtTokenarray[1];
		String header = decryptBase64(array[0]);
		String payload = decryptBase64(array[1]);
		//String key = jwtTokenarray[2];
		System.out.println(header);
		System.out.println(payload);
		String vcheck = array[0]+"."+array[1];
		System.out.println(encode("your-256-bit-secret", vcheck));
}
	 public static String encryptBase64(String value){
		 String encodedString = Base64.getEncoder().encodeToString(value.getBytes());
			return encodedString;
	 }
	 public static String decryptBase64(String encodedString){
		 byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
			String decodedString = new String(decodedBytes);
			return decodedString;
	 }
	 public static String makeSignature(String header, String payload, String  secret) throws NoSuchAlgorithmException{
		 String originalString = header+"."+payload + "."+secret; 
		 MessageDigest digest = MessageDigest.getInstance("SHA-256");
		 byte[] encodedhash = digest.digest(
		   originalString.getBytes(StandardCharsets.UTF_8));
		 String encodedhashString = new String(encodedhash); 
		 return encodedhashString;
	 }
	 private static String encode(String key, String data) throws Exception {
		 		  Mac sha256_HMAC = Mac.getInstance("HMACSHA256");
		 		  SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		 		  sha256_HMAC.init(secret_key);
		 		 return (encryptBase64(Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")))));
				 
		 		}
}