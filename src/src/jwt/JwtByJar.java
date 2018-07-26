package src.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import main.java.JWTdecryption;

public class JwtByJar {

	public static void main(String[] args) {
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
		DecodedJWT jwt = null;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		     jwt = verifier.verify(token);
		    System.out.println(jwt.getPayload());
		} catch (JWTVerificationException exception){
		    System.out.println("wrong password");
		}
		
		System.out.println(JWTdecryption.decryptBase64(jwt.getHeader()));
		
	}

}
