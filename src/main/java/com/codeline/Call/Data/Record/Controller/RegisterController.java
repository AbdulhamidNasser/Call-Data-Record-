package com.codeline.Call.Data.Record.Controller;

import com.codeline.Call.Data.Record.Model.Register;
import com.codeline.Call.Data.Record.RequestObj.RegisterRequestObj;
import com.codeline.Call.Data.Record.RequestObj.ReportRequestObj;
import com.codeline.Call.Data.Record.Servise.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/api/register")
    public ResponseEntity<Void> registerUser (@RequestBody RegisterRequestObj registerRequestObj) {
        createUser(registerRequestObj);
        return ResponseEntity.ok().build();

    }
    public void createUser(RegisterRequestObj registerRequestObj){
        Register registerObj = new Register();
        registerObj.setEmail(registerRequestObj.getEmail());
        registerObj.setPassword(registerRequestObj.getPassword());
        registerObj.setUsername(registerRequestObj.getUsername());
        registerService.register(registerObj);
    }


}

