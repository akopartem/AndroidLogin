package xyz.akopartem.loginagada;

import java.util.regex.Pattern;

public class Validator {
    static boolean checkUsername(String uname) {
        return Pattern.compile("[a-zA-z1-9_-]+$").matcher(uname).matches();
    }

    static boolean checkPass(String pass) {
        return Pattern.compile("[a-zA-z1-9!.-]+$").matcher(pass).matches();

    }
}
