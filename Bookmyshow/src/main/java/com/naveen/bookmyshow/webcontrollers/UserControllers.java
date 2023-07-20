package com.naveen.bookmyshow.webcontrollers;

import com.naveen.bookmyshow.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserControllers {


    @Autowired
    private  UserService userService;





    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUSer(@RequestBody RegisterRequest request, BindingResult result )
    {

        return ResponseEntity.ok(userService.saveUser(request));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request, BindingResult result )
    {

        return ResponseEntity.ok(userService.saveAdmin(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateLogin(@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(userService.login(request));
    }



}
