package com.myentry.MyEntry.controller;


import com.myentry.MyEntry.constants.APIConstants;
import com.myentry.MyEntry.domain.User;
import com.myentry.MyEntry.dto.JwtRequest;
import com.myentry.MyEntry.dto.JwtResponse;
import com.myentry.MyEntry.dto.LoginUser;
import com.myentry.MyEntry.repository.UserRepository;
import com.myentry.MyEntry.services.JwtUserDetailsService;
import com.myentry.MyEntry.utils.JwtTokenUtil;
import org.codehaus.groovy.syntax.TokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Author : SAURAV ROY
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<?> createJWTToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     *
     * @param loginUser {@link LoginUser}
     * @return ResponseEntity<?>
     * @throws AuthenticationException
     */
    @RequestMapping(value = APIConstants.AUTHENTICATION_API, method = RequestMethod.PUT)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        User user = userRepository.findByUsername(loginUser.getUsername());
        user.loginDateSetter();
        userRepository.save(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateTokens(authentication);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = APIConstants.LOGOUT_CURRENT_USER,method = RequestMethod.POST)
    public ResponseEntity<?> logoutUser() throws TokenException {
        return  null;
    }


    /**
     *
     * @param username {@link String}
     * @param password {@link String}
     * @throws Exception
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
