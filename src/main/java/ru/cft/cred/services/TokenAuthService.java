package ru.cft.cred.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

//@Service
public class TokenAuthService {

	private String JWT_KEY = "SecretKeyToGenJWTs";
	private final String SECRET_KEY = null;
	private final long EXPIRATION_TIME = 864_000_000; // 10 days
	private final String TOKEN_PREFIX = "Bearer";
	private final String AUTH_HEADER_NAME = "X-Auth-Token";
	//private final String SIGN_UP_URL = "/users/sign-up";

	public TokenAuthService() throws Base64DecodingException {
		byte[] decodedKey = Base64.decode(JWT_KEY);

	}

	public Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(AUTH_HEADER_NAME);

		if (token == null || !token.startsWith(TOKEN_PREFIX))
			return null;

//		String user = Jwts.parser()
//                .setSigningKey(SECRET.getBytes())
//                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                .getBody()
//                .getId();
		
		//		if (user != null)
		//			return null;


		//Jws<Claims>

		return null;
		//return Optional<T>.ofNullable(request.getHeader(AUTH_HEADER_NAME)).;
	}

	private long extractUserId(String token) {
		return 0;
	}
}
