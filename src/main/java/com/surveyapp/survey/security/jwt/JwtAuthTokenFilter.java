package com.surveyapp.survey.security.jwt;

import com.surveyapp.survey.security.service.impl.UserDetailsServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    private UserDetailsServiceImpl userDetailsService;
    private JwtProvider tokenProvider;
    private static final String REQUEST_HEADER_NAME="Authorization";
    private final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    @Autowired
    public JwtAuthTokenFilter(UserDetailsServiceImpl userDetailsService, JwtProvider tokenProvider) {
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwt(httpServletRequest);
            // if jwt is valid
            if(jwt != null && tokenProvider.isJwtValid(jwt)) {
                /**
                // get user data from DB
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                 */
                UserDetails userDetails = tokenProvider.getUserDetailsFromToken(jwt);
                // refresh authentication
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                // set new authentication
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwt(HttpServletRequest httpServletRequest) {
        // get request header
        String authHeader = httpServletRequest.getHeader(REQUEST_HEADER_NAME);
        String headerInitPart = JwtHeaderProperties.BEARER.getType()+" ";
        // if header is not null extract jwt
        if (authHeader != null && authHeader.startsWith(headerInitPart)) {
            return authHeader.replace(headerInitPart, "");
        }
        return null;
    }

}
