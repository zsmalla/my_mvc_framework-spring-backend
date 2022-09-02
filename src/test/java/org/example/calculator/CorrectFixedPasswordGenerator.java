package org.example.calculator;

import org.example.calculator.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefgh";  // 8글자
    }
}
