package com.musyan.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header;
        String token;
        String username;
        header = request.getHeader("Authorization");

        if(header==null){
            filterChain.doFilter(request,response);
            return;
        }

        token = header.substring(7);

        try {
            username = jwtService.getUsernameByToken(token);

            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
               UserDetails userDetails =  userDetailsService.loadUserByUsername(username);
               if(userDetails!=null && jwtService.isTokenExpired(token)){
                   //kisi artık SecurityContexte konulabilir

                   UsernamePasswordAuthenticationToken authentication =
                           new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());

                   authentication.setDetails(userDetails);

                   SecurityContextHolder.getContext().setAuthentication(authentication);

               }

            }
        }catch (ExpiredJwtException e){
            System.out.println("Token süresi dolmuştur : "+ e.getMessage());

        }catch (Exception e){
            System.out.println("Genel bi hata var : "+ e.getMessage());
        }

        filterChain.doFilter(request,response);
    }
}
