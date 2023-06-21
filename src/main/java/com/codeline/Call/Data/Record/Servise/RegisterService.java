package com.codeline.Call.Data.Record.Servise;

import com.codeline.Call.Data.Record.Model.Register;
import com.codeline.Call.Data.Record.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository;
    public void register(Register register) {
        registerRepository.save(register);
    }


}
