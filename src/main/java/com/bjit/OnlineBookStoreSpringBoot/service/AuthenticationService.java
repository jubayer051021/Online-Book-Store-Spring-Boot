package com.bjit.OnlineBookStoreSpringBoot.service;

import com.bjit.OnlineBookStoreSpringBoot.entity.Role;
import com.bjit.OnlineBookStoreSpringBoot.entity.User;
import com.bjit.OnlineBookStoreSpringBoot.model.AuthenticationResponseModel;
import com.bjit.OnlineBookStoreSpringBoot.model.LoginRequestModel;
import com.bjit.OnlineBookStoreSpringBoot.model.UserRequestModel;
import com.bjit.OnlineBookStoreSpringBoot.repository.UserRepository;
import com.bjit.OnlineBookStoreSpringBoot.utils.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        User user = User.builder()
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .email(requestModel.getEmail())
                .role(Objects.equals(requestModel.getRole(), "ADMIN") ? Role.ADMIN:Role.CUSTOMER )
                .address(requestModel.getAddress())
                .password(passwordEncoder.encode(requestModel.getPassword()))
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponseModel auth = AuthenticationResponseModel.builder().token(jwtToken).build();
        return new ResponseEntity<>(auth, HttpStatus.CREATED);
    }

    public AuthenticationResponseModel login(LoginRequestModel requestModel) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                requestModel.getEmail(),
                requestModel.getPassword()
        ));
        var user = userRepository.findByEmail(requestModel.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseModel.builder().token(jwtToken).build();
    }
}
