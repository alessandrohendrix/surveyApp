package com.surveyapp.survey.security.jwt;

import com.surveyapp.survey.security.authentication.Authority;
import com.surveyapp.survey.security.authentication.JwtUser;
import com.surveyapp.survey.security.authentication.UserPrincipal;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class JwtProvider {

    @Value("${jwtSecret}")
    private String jwtSecret;
    @Value("${jwtExpiration}")
    private int jwtExpiration;

    private static final String CLAIM_KEY_AUTHORITIES = "authorities";
    private static final String CLAIM_KEY_ID = "id";
    private static final String CLAIM_SUBJECT = "subject";
    private static final String CLAIM_ISSUED = "issuedAt";

    public String generateJwt(Authentication auth) {
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        Map<String, Object> claims = buildClaims(userPrincipal);
        return generateJwt(claims, userPrincipal.getUsername());
    }

    private Map<String, Object> buildClaims(UserPrincipal userPrincipal) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_ID, userPrincipal.getID());
        claims.put(CLAIM_SUBJECT, userPrincipal.getUsername());
        claims.put(CLAIM_ISSUED, new Date());
        List<String> authorities = userPrincipal
                .getAuthorities()
                .stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toList());
        claims.put(CLAIM_KEY_AUTHORITIES, authorities);
        return claims;
    }

    private String generateJwt(Map<String, Object> claims, String subject) {
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date((now).getTime()+jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean isJwtValid(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private Claims getTokenClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }

    public JwtUser getUserDetailsFromToken(String token) {
        final Claims claims = getTokenClaims(token);
        String username = (String)claims.get(CLAIM_SUBJECT);
        Integer ID = (Integer)claims.get(CLAIM_KEY_ID);
        Set<GrantedAuthority> authorities = null;
        Object roles = claims.get(CLAIM_KEY_AUTHORITIES);
        if(roles != null) {
            authorities = ((List<String>) roles).stream().map(role -> new Authority(role)).collect(Collectors.toSet());
        }
        return new JwtUser(username, "", authorities, ID);
    }
}
