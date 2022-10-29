/**
 * 
 */
package com.market.demo.web.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author juaneins_uio
 *
 */
@Component
public class JWTUtil {
	
	private static final String KEY = "Ju4n0";
	
	public String generate(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
	}

}
