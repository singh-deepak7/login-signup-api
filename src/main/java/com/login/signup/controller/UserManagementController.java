package com.login.signup.controller;


import com.login.signup.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1")
public class UserManagementController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/loadpage", method = RequestMethod.POST)
    public ResponseEntity<Users> createAuthenticationToken(@RequestBody Users user) throws Exception {
        System.out.println(user.getEmail());
        Users use = new Users();
        use.setEmail("abc@abc.com");
        use.setFirstName("ABC");
        return new ResponseEntity<Users>(use, HttpStatus.OK);

    }
}

