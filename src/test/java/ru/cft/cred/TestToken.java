package ru.cft.cred;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TestToken {

	private static String JWT_KEY = "SecretKeyToGenJWTs00";
	private static SecretKeySpec SECRET_KEY = null;

	public static void main(String[] args) throws Base64DecodingException {
		// TODO Auto-generated method stub
		Init.init();
		//byte[] decodedKey = Base64.decode(JWT_KEY);
		//SECRET_KEY = new SecretKeySpec(decodedKey, i:0, decodedKey.length, s: "AES");
		String token = Jwts.builder()
							.setId("123")
							.setExpiration(new Date())
				.signWith(SignatureAlgorithm.ES256, JWT_KEY)
							.compact();
		System.out.println(token);
	}

}
