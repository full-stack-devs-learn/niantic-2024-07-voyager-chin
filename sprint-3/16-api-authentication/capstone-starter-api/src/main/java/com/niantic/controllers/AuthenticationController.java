package com.niantic.controllers;

import com.niantic.security.jwt.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.niantic.data.UserDao;
import com.niantic.models.authentication.LoginDto;
import com.niantic.models.authentication.LoginResponseDto;
import com.niantic.models.authentication.RegisterUserDto;
import com.niantic.models.User;

@RestController
@CrossOrigin
@PreAuthorize("permitAll()")
public class AuthenticationController
{

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserDao userDao;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil, UserDao userDao)
    {

        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userDao = userDao;
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody LoginDto loginDto) throws Exception
    {
        try
        {
            var authToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
            authenticationManager.authenticate(authToken);
        }
        catch (AuthenticationException e)
        {
            return ResponseEntity.notFound().build();
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        try
        {
            User user = userDao.getByUserName(loginDto.getUsername());

            if (user == null)
            {
                return ResponseEntity.notFound().build();
            }

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + jwt);
            return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Oops... something went wrong");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto newUser)
    {

        try
        {
            boolean exists = userDao.exists(newUser.getUsername());
            if (exists)
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }

            // create user
            User user = userDao.create(new User(0, newUser.getUsername(), newUser.getPassword(), newUser.getRole()));

            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Oops... something went wrong");
        }
    }

}

