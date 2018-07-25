package main.java;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class JWTdecryption {
	public static void main (String ...args) throws NoSuchAlgorithmException{
		
		String jwtToken = new String("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ1c2VyMSJ9.HG9GCQPuC6w6pulbYE2uurCzpEwoWvz_8Ps5ZjgtfomyY4LWacDEzlHLnyMj9H7aqgcePC7_4l2wDXQV-S0BQRsIZfJeUUmWxlTlLzvKZr_2eEx00YZPPFZNoFCfwB-ajLHLLenROy4aSjPo_Vg9o7N-p0DZ1yZQoJhkvoVJgkhX9FeAf65kIZkbuJC9dmVkzXSOpVf4GZeCpNDJJYSo6IAnL3UEoWek6V9BtWgV-a4xvydp7vxkdDXmzmalGLYuWbuVG7rWcbWwSfsg38iEG-mqptqA_Kzk1VmjwWNo_BfvLuzjzuosqi732-5SRzBP-2zqGghBqMYsGgkqkH2n7A");;
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
		System.out.println(makeSignature(array[0], array[1],"secrect"));
}
	 public String encryptBase64(String value){
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
}