package org.example;

public class WrongFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword() {
        return "aa";  // 8글자
    }
}
