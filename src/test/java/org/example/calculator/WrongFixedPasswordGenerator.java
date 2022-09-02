package org.example.calculator;

import org.example.calculator.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "aa";  // 8글자
    }
}
