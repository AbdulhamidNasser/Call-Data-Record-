package com.codeline.Call.Data.Record.RequestObj;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequestObj {
    String username;
    String password;
    String email;
}
