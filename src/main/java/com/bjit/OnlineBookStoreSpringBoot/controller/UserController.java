package com.bjit.OnlineBookStoreSpringBoot.controller;

import com.bjit.OnlineBookStoreSpringBoot.model.AuthenticationResponseModel;
import com.bjit.OnlineBookStoreSpringBoot.model.LoginRequestModel;
import com.bjit.OnlineBookStoreSpringBoot.model.UserRequestModel;
import com.bjit.OnlineBookStoreSpringBoot.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestModel requestModel){
        return authenticationService.register(requestModel);
    }
    @PostMapping("/login")
    public AuthenticationResponseModel login(@RequestBody LoginRequestModel requestModel){
        return authenticationService.login(requestModel);
    }
    @GetMapping("/hello")
    public String helloWorld(){
        return "I am jubayer";
    }
}
