package com.naveen.bookmyshow.services;

import com.naveen.bookmyshow.DAO.UserRepository;
import com.naveen.bookmyshow.pojo.Role;
import com.naveen.bookmyshow.pojo.User;
import com.naveen.bookmyshow.security.JwtService;
import com.naveen.bookmyshow.webcontrollers.AuthenticationRequest;
import com.naveen.bookmyshow.webcontrollers.AuthenticationResponse;
import com.naveen.bookmyshow.webcontrollers.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public UserService() {
    }

    public AuthenticationResponse saveUser(RegisterRequest request) {

        var user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse saveAdmin(RegisterRequest request) {

        var admin = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        userRepository.save(admin);

        var jwtToken = jwtService.generateToken(admin);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

        public AuthenticationResponse login(AuthenticationRequest request){
             authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

             var user  = userRepository.findByEmail(request.getEmail())
                     .orElseThrow();
             var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        }

