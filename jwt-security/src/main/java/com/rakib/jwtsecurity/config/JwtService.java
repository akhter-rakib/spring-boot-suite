package com.rakib.jwtsecurity.config;

import com.rakib.jwtsecurity.dto.UserPrinciple;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.rakib.jwtsecurity.util.DateUtil.getExpiration;

@Service
public class JwtService {

    /*https://www.allkeysgenerator.com/Random/Security-Encryption-Key-Generator.aspx*/
    private static final String SECRET_KEY = "5A7234753778214125442A462D4A614E645267556B58703273357638792F423F";
    private final Long expireHour = Long.valueOf("5");

    public String generateToken(Authentication authentication) {
        return generateToken(new HashMap<>(), authentication);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            Authentication authentication
    ) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(getExpiration(expireHour))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String generateToken(String username, HttpServletRequest request) {
        return Jwts
                .builder()
                .claim("ip", request.getRemoteAddr())
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(getExpiration(expireHour))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(((UserPrinciple) userDetails).getEmail()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractIp(String token) {
        return (String) extractAllClaims(token).get("ip");
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
